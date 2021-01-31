package com.blf.gameservice.daodb;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.dao.EventDao;
import com.blf.gameservice.model.entity.Event;
import com.blf.gameservice.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventDaoDB implements EventDao {

    private final EventRepository eventRepository;


    //TODO remove limiter
    @Override
    public List<Event> getAllEvents() {
        int limiter = 150;
        return eventRepository.findAll().stream().limit(limiter).collect(Collectors.toList());
    }

    @Override
    public List<Event> getEventsBySearch(SearchInput input) {
        return eventRepository.findAllBySearch(input.getInput());
    }

    @Override
    public List<Event> getEventsBySeasonAndSearch(Long seasonId) {
        return eventRepository.findAllBySeasonId(seasonId);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    @Override
    public Event addNewEvent(Event event) {
        return eventRepository.saveAndFlush(event);
    }

    @Override
    public void updateEvent(Event updatedEvent) {
        eventRepository.saveAndFlush(updatedEvent);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.findById(eventId)
                .ifPresent(eventToDelete -> eventRepository.deleteById(eventId));
    }
}
