package com.blf.gameservice.controller;

import com.blf.gameservice.search.SearchInput;
import com.blf.gameservice.model.dto.EventDTO;
import com.blf.gameservice.model.entity.Event;
import com.blf.gameservice.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class EventController {

    private final EventService eventService;


/*
    @GetMapping("")
    public List<EventDTO> getAllEvents() {
        return eventService.getAllEvents();
    }
*/

    @GetMapping("")
    public List<EventDTO> getAllLatestEvent(){
        return eventService.getLatestEvents();
    }

    @GetMapping("/{eventId}")
    public EventDTO getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId);
    }

    @PostMapping("/search")
    public List<EventDTO> getAllEventsBySearch(@RequestBody SearchInput input){
        return eventService.getEventsBySearch(input);
    }

    @PostMapping("/search/{seasonId}")
    public List<EventDTO> getAllEventsBySeasonAndSearch(@PathVariable Long seasonId, @RequestBody(required = false) SearchInput input){
        return eventService.getEventsBySeasonAndSearch(seasonId, input);
    }

    @PostMapping("")
    public EventDTO addNewEvent(@RequestBody Event event) {
        log.info("The following event is added to database: " + event);
        return eventService.addNewEvent(event);
    }

    @PutMapping("/{eventId}")
    public EventDTO updateEvent(@PathVariable Long eventId, @RequestBody Event updatedEvent) throws IllegalAccessException {
        return eventService.updateEvent(eventId, updatedEvent);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }

}
