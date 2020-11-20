package com.blf.gameservice.daodb;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.dao.EventDao;
import com.blf.gameservice.entity.Event;
import com.blf.gameservice.repository.EventRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class EventDaoDB implements EventDao {

    EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getEventsBySearch(SearchInput input) {
        return eventRepository.findAllBySearch(input.getInput());
    }

    @Override
    public List<Event> getEventsBySeasonAndSearch(Long seasonId, SearchInput input) {
        List<Event> events = eventRepository.findAllBySeasonId(seasonId);
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

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    @Override
    public Event addNewEvent(Event event) {
        return eventRepository.saveAndFlush(event);
    }

    @Override
    public Event updateEvent(Long eventId, Event updatedEvent) {
        Event eventToUpdate = eventRepository.findById(eventId).orElse(null);

        if (eventToUpdate != null) {
            eventToUpdate.setA1qScore(updatedEvent.getA1qScore());
            eventToUpdate.setA2qScore(updatedEvent.getA2qScore());
            eventToUpdate.setA3qScore(updatedEvent.getA3qScore());
            eventToUpdate.setA4qScore(updatedEvent.getA4qScore());
            eventToUpdate.setAExScore(updatedEvent.getAExScore());

            eventToUpdate.setH1qScore(updatedEvent.getH1qScore());
            eventToUpdate.setH2qScore(updatedEvent.getH2qScore());
            eventToUpdate.setH3qScore(updatedEvent.getH3qScore());
            eventToUpdate.setH4qScore(updatedEvent.getH4qScore());
            eventToUpdate.setHExScore(updatedEvent.getHExScore());

            eventToUpdate.setA1qTaken(updatedEvent.getA1qTaken());
            eventToUpdate.setA2qTaken(updatedEvent.getA2qTaken());
            eventToUpdate.setA3qTaken(updatedEvent.getA3qTaken());
            eventToUpdate.setA4qTaken(updatedEvent.getA4qTaken());
            eventToUpdate.setAExTaken(updatedEvent.getAExTaken());

            eventToUpdate.setH1qTaken(updatedEvent.getH1qTaken());
            eventToUpdate.setH2qTaken(updatedEvent.getH2qTaken());
            eventToUpdate.setH3qTaken(updatedEvent.getH3qTaken());
            eventToUpdate.setH4qTaken(updatedEvent.getH4qTaken());
            eventToUpdate.setHExTaken(updatedEvent.getHExTaken());

            eventToUpdate.setAddress(updatedEvent.getAddress());
            eventToUpdate.setEventDate(updatedEvent.getEventDate());
            eventToUpdate.setSummary(updatedEvent.getSummary());
            eventToUpdate.setLeague(updatedEvent.getLeague());

            eventRepository.saveAndFlush(eventToUpdate);
        } else {
            log.info("Event not found with the following id: " + eventId);
        }
        return eventToUpdate;
    }

    @Override
    public Event deleteEvent(Long eventId) {
        Event eventToDelete = eventRepository.findById(eventId).orElse(null);

        if (eventToDelete != null) {
            eventRepository.deleteById(eventId);
        }
        return eventToDelete;
    }
}
