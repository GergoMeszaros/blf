package com.blf.gameservice.dao;

import com.blf.gameservice.entity.Event;
import com.blf.gameservice.repository.EventRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Event> getEventsByAnyTeamId(Integer teamId) {
        return eventRepository.getEventsByAnyTeamId(teamId);
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

            eventToUpdate.setHomeTeamId(updatedEvent.getHomeTeamId());
            eventToUpdate.setAwayTeamId(updatedEvent.getAwayTeamId());
            eventToUpdate.setAddress(updatedEvent.getAddress());
            eventToUpdate.setEventDate(updatedEvent.getEventDate());
            eventToUpdate.setSummary(updatedEvent.getSummary());
            eventToUpdate.setLeague(updatedEvent.getLeague());
            eventToUpdate.setBestPlayerId(updatedEvent.getBestPlayerId());

            eventRepository.saveAndFlush(eventToUpdate);
        } else {
            log.info("Event not found with the following id: " + eventId);
        }
        return eventToUpdate;
    }
}
