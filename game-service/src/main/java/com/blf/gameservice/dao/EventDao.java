package com.blf.gameservice.dao;
import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.entity.Event;

import java.util.List;

public interface EventDao {

    List<Event> getAllEvents();

    List<Event> getEventsBySeasonOrSearch(Long seasonId, SearchInput input);

    Event getEventById(Long eventId);

    Event addNewEvent(Event event);

    Event updateEvent(Long eventId, Event updatedEvent);

    Event deleteEvent(Long eventId);

}
