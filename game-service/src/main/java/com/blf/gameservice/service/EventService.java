package com.blf.gameservice.service;


import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.dao.EventDao;
import com.blf.gameservice.entity.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Event> getEventsBySeasonAndSearch(Long seasonId, SearchInput input) {
        return eventDao.getEventsBySeasonAndSearch(seasonId, input);
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
