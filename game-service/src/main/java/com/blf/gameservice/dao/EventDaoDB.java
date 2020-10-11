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

    EventRepository matchRepository;

    @Override
    public List<Event> getAllMatches() {
        return matchRepository.findAll();
    }
}
