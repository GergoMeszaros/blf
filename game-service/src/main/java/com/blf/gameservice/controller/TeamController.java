package com.blf.gameservice.controller;
import com.blf.gameservice.dao.TeamDao;
import com.blf.gameservice.entity.Team;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@AllArgsConstructor
@Slf4j
public class TeamController {

    TeamDao teamDao;

    @GetMapping("")
    public List<Team> getAllTeam(){
        return teamDao.getAllTeam();
    }

    @PostMapping("/add")
    public Team addNewTeam(@RequestBody Team team){
        return teamDao.addNewTeam(team);
    }

    @PutMapping("/edit/{teamId}")
    public Team updateTeam(@PathVariable Long teamId, @RequestBody Team updatedTeam){
        return teamDao.updateTeam(teamId,updatedTeam);
    }

    @DeleteMapping("/delete/{teamId}")
    public Team deleteTeam(@PathVariable Long teamId){
        return teamDao.deleteTeam(teamId);
    }
}
