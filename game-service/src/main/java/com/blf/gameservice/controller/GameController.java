package com.blf.gameservice.controller;
import com.blf.gameservice.dao.*;
import com.blf.gameservice.entity.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
@AllArgsConstructor
@Slf4j
public class GameController {

    LeagueDao leagueDao;
    SeasonDao seasonDao;
    EventDao eventDao;
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;

    @GetMapping("/seasons")
    public List<Season> getAllSeasons() {
        return seasonDao.getAllSeason();
    }

    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return leagueDao.getAllLeagues();
    }

    @GetMapping("/matches")
    public List<Event> getAllEvents(){
        return eventDao.getAllEvents();
    }

    @GetMapping("/matches/{teamId}")
    public List<Event> xyz(@PathVariable Integer teamId){
        return eventDao.getEventsByAnyTeamId(teamId);
    }




    @GetMapping("/teams")
    public List<Team> getAllTeam(){
        return teamDao.getAllTeam();
    }

    @GetMapping("/members")
    public List<TeamMember> getAllTeamMembers(){
        return teamMemberDao.getAllTeamMembers();
    }
}
