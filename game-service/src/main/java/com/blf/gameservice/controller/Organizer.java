package com.blf.gameservice.controller;
import com.blf.gameservice.dao.*;
import com.blf.gameservice.entity.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
@AllArgsConstructor
@Slf4j
public class Organizer {

    LeagueDao leagueDao;
    SeasonDao seasonDao;
    EventDao eventDao;
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;


    @GetMapping("/members")
    public List<TeamMember> getAllTeamMembers(){
        return teamMemberDao.getAllTeamMembers();
    }
}
