package com.blf.gameservice.dao;
import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.entity.Event;

import java.util.List;

public interface EventDao {

    List<Event> getAllEvents();

    List<Event> getEventsBySeasonAndSearch(Long seasonId, SearchInput input);

    List<Event> getEventsBySearch(SearchInput input);

    Event getEventById(Long eventId);

    Event addNewEvent(Event event);

    Event updateEvent(Event updatedEvent) throws IllegalAccessException;

    Event deleteEvent(Long eventId);

}
