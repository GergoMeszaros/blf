package com.blf.gameservice.controller;

import com.blf.gameservice.dao.EventDao;
import com.blf.gameservice.entity.Event;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class EventController {

    EventDao eventDao;

    @GetMapping("")
    public List<Event> getAllEvents() {
        return eventDao.getAllEvents();
    }

    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable Long eventId) {
        return eventDao.getEventById(eventId);
    }

    @PostMapping("/add")
    public Event addNewEvent(@RequestBody Event event) {
        log.info("The following event is added to database: " + event);
        return eventDao.addNewEvent(event);
    }

    @PutMapping("/edit/{eventId}")
    public Event updateEvent(@PathVariable Long eventId, @RequestBody Event updatedEvent) {
        return eventDao.updateEvent(eventId, updatedEvent);
    }

    @DeleteMapping("/delete/{eventId}")
    public Event deleteEvent(@PathVariable Long eventId) {
        return eventDao.deleteEvent(eventId);
    }

}
