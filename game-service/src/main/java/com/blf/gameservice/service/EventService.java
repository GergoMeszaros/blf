package com.blf.gameservice.service;


import com.blf.gameservice.search.SearchInput;
import com.blf.gameservice.dao.EventDao;
import com.blf.gameservice.dao.LatestSeasonDao;
import com.blf.gameservice.model.dto.EventDTO;
import com.blf.gameservice.model.entity.Event;
import com.blf.gameservice.model.entity.Season;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventDao eventDao;
    private final UpdateValidator updateValidator;
    private final LatestSeasonDao latestSeasonDao;
    private final DtoCreator<Event, EventDTO> dtoCreator;


    public List<EventDTO> getAllEvents() {
        return dtoCreator.handleListInput(
                eventDao.getAllEvents());
    }

    public List<EventDTO> getEventsBySearch(SearchInput input) {
        return dtoCreator.handleListInput(
                eventDao.getEventsBySearch(input));
    }

    /**
     * The business logic of this method is moved from the DAO implementation to here.
     * If we have typed input from the front-end, we convert it to lowercase and check
     * if any of the results'(events) fields contains any part of the input.
     */
    public List<EventDTO> getEventsBySeasonAndSearch(Long seasonId, SearchInput input) {

        List<Event> events = eventDao.getEventsBySeasonAndSearch(seasonId);

        if (input != null) {

            String lowerCaseInput = input.getInput().toLowerCase();

            return dtoCreator.handleListInput(events
                    .stream()
                    .filter(event -> event.getAddress().toLowerCase().contains(lowerCaseInput)
                            || event.getHomeTeam().getName().toLowerCase().contains(lowerCaseInput)
                            || event.getAwayTeam().getName().toLowerCase().contains(lowerCaseInput)
                            || event.getLeague().getName().toLowerCase().contains(lowerCaseInput))
                    .collect(Collectors.toList()));
        } else {
            return dtoCreator.handleListInput(events);
        }
    }

    public EventDTO getEventById(Long eventId) {
        return dtoCreator.handleSingleInput(
                eventDao.getEventById(eventId));
    }

    public EventDTO addNewEvent(Event event) {
        event.setSeason(Season.builder()
                .id(latestSeasonDao.getTheLatestSeasonId())
                .build());
        return dtoCreator.handleSingleInput(eventDao.addNewEvent(event));
    }

    public EventDTO updateEvent(Long eventId, Event updatedEvent) throws IllegalAccessException {
        Event eventToUpdate = eventDao.getEventById(eventId);

        if (eventToUpdate != null) {
            Event validatedEvent = updateValidator.updater(eventToUpdate, updatedEvent);
            eventDao.updateEvent(validatedEvent);
        } else {
            log.info("Event not found with the following id: " + eventId);
        }
        return dtoCreator.handleSingleInput(eventToUpdate);
    }

    public void deleteEvent(Long eventId) {
        eventDao.deleteEvent(eventId);

    }
}
