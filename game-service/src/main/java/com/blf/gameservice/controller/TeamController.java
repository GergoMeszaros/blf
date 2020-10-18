package com.blf.gameservice.controller;
import com.blf.gameservice.dao.TeamDao;
import com.blf.gameservice.dto.PlayerDTO;
import com.blf.gameservice.entity.Team;
import com.blf.gameservice.servicecaller.TeamMemberServiceCaller;
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

    TeamMemberServiceCaller teamMemberServiceCaller;

    @GetMapping("")
    public List<Team> getAllTeam() {
        return teamDao.getAllTeam();
    }

    @GetMapping("/blfteams")
    public List<Team> getALlBflTeams() {
        return teamDao.getAllBlfTeams();
    }

    @PostMapping("/add")
    public Team addNewTeam(@RequestBody Team team) {
        return teamDao.addNewTeam(team);
    }

    @PutMapping("/edit/{teamId}")
    public Team updateTeam(@PathVariable Long teamId, @RequestBody Team updatedTeam) {
        return teamDao.updateTeam(teamId, updatedTeam);
    }

    @DeleteMapping("/delete/{teamId}")
    public Team deleteTeam(@PathVariable Long teamId) {
        return teamDao.deleteTeam(teamId);
    }

    @GetMapping("/members")
    public List<PlayerDTO> getPlayersForSC() {
        return teamMemberServiceCaller.getPlayersForSC();
    }

}
