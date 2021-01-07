package com.blf.gameservice.service;


import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.dao.EventDao;
import com.blf.gameservice.entity.Event;
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


    public List<Event> getAllEvents() {
        return eventDao.getAllEvents();
    }

    public List<Event> getEventsBySearch(SearchInput input) {
        return eventDao.getEventsBySearch(input);
    }

    /**
     The business logic of this method is moved from the DAO implementation to here.
     If we have typed input from the front-end, we convert it to lowercase and check
        if any of the results'(events) fields contains any part of the input.
    */
    public List<Event> getEventsBySeasonAndSearch(Long seasonId, SearchInput input) {

        List<Event> events = eventDao.getEventsBySeasonAndSearch(seasonId);

        if (input != null) {

            String lowerCaseInput = input.getInput().toLowerCase();

            return events
                    .stream()
                    .filter(event -> event.getAddress().toLowerCase().contains(lowerCaseInput)
                            || event.getHomeTeam().getName().toLowerCase().contains(lowerCaseInput)
                            || event.getAwayTeam().getName().toLowerCase().contains(lowerCaseInput)
                            || event.getLeague().getName().toLowerCase().contains(lowerCaseInput))
                    .collect(Collectors.toList());
        } else {
            return events;
        }
    }

    public Event getEventById(Long eventId) {
        return eventDao.getEventById(eventId);
    }

    public Event addNewEvent(Event event) {
        return eventDao.addNewEvent(event);
    }

    public Event updateEvent(Long eventId, Event updatedEvent) throws IllegalAccessException {
        Event eventToUpdate = eventDao.getEventById(eventId);

        if (eventToUpdate != null) {
            Event validatedEvent = updateValidator.updater(eventToUpdate, updatedEvent);
            eventDao.updateEvent(validatedEvent);
        } else {
            log.info("Event not found with the following id: " + eventId);
        }
        return eventToUpdate;
    }

    public Event deleteEvent(Long eventId) {
        return eventDao.deleteEvent(eventId);
    }
}
