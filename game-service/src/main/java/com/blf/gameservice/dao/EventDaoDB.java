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
}
