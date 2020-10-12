package com.blf.gameservice.controller;

import com.blf.gameservice.dao.EventDao;
import com.blf.gameservice.entity.Event;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
@Slf4j
public class EventController {

    EventDao eventDao;

    @GetMapping("")
    public List<Event> getAllEvents(){
        return eventDao.getAllEvents();
    }

    @GetMapping("/team/{teamId}")
    public List<Event> getEventsByAnyTeamId(@PathVariable Integer teamId){
        return eventDao.getEventsByAnyTeamId(teamId);
    }
}
