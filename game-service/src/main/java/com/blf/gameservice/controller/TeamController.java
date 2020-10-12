package com.blf.gameservice.controller;
import com.blf.gameservice.dao.TeamDao;
import com.blf.gameservice.entity.Team;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
@AllArgsConstructor
@Slf4j
public class TeamController {

    TeamDao teamDao;

    @GetMapping("/")
    public List<Team> getAllTeam(){
        return teamDao.getAllTeam();
    }

}
