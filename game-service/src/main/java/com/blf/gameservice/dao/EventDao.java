package com.blf.gameservice.dao;
import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.model.entity.Event;

import java.util.List;

public interface EventDao {

    List<Event> getAllEvents();

    List<Event> getEventsBySeasonAndSearch(Long seasonId);

    List<Event> getEventsBySearch(SearchInput input);

    Event getEventById(Long eventId);

    Event addNewEvent(Event event);

    void updateEvent(Event updatedEvent) throws IllegalAccessException;

    void deleteEvent(Long eventId);

}
