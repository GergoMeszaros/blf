package com.blf.gameservice.controller;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.dao.TeamDao;
import com.blf.gameservice.entity.Team;
import com.blf.gameservice.dtoservice.TeamMemberServiceCaller;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class TeamController {

    TeamDao teamDao;

    TeamMemberServiceCaller teamMemberServiceCaller;

    @GetMapping("")
    public List<Team> getAllTeam() {
        return teamDao.getAllTeam();
    }

    @GetMapping("/season/{seasonId}")
    public List<Team> getAllTeamsBySeason(@PathVariable Long seasonId) {
        return teamDao.getAllTeamsBySeasonId(seasonId);
    }

    @PostMapping("/name")
    public List<Team> getTeamsByTeamName(@RequestBody SearchInput teamName){
        return teamDao.getTeamsByTeamName(teamName);
    }

    @GetMapping("/{teamId}")
    public Team getTeamById(@PathVariable Long teamId) {
        return teamDao.getTeamById(teamId);
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

   /* @GetMapping("/members")
    public List<PlayerDTO> getPlayersForSC() {
        return teamMemberServiceCaller.getPlayersForSC();
    }*/

}
