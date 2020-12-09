package com.blf.gameservice.controller;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.entity.Team;
import com.blf.gameservice.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class TeamController {

    private final TeamService teamService;

    //TeamMemberServiceCaller teamMemberServiceCaller;


    @GetMapping("")
    public List<Team> getAllTeam() {
        return teamService.getAllTeam();
    }

    @GetMapping("/{teamId}")
    public Team getTeamById(@PathVariable Long teamId) {
        return teamService.getTeamById(teamId);
    }

    @GetMapping("/blfteams")
    public List<Team> getALlBflTeams() {
        return teamService.getAllBlfTeams();
    }

    @PostMapping("/search/{seasonId}")
    public List<Team> getAllTeamsBySeason(@PathVariable Long seasonId) {
        return teamService.getAllTeamsBySeasonId(seasonId);
    }

    @PostMapping("/search")
    public List<Team> getTeamsByTeamName(@RequestBody SearchInput teamName) {
        return teamService.getTeamsByTeamName(teamName);
    }

    //TODO Search with input and season together is missing ---> sample in EventDaoDB !!!!

    @PostMapping("")
    public Team addNewTeam(@RequestBody Team team) {
        return teamService.addNewTeam(team);
    }

    @PutMapping("/{teamId}")
    public Team updateTeam(@PathVariable Long teamId, @RequestBody Team updatedTeam) {
        return teamService.updateTeam(teamId, updatedTeam);
    }

    @DeleteMapping("/{teamId}")
    public Team deleteTeam(@PathVariable Long teamId) {
        return teamService.deleteTeam(teamId);
    }

   /* @GetMapping("/members")
    public List<PlayerDTO> getPlayersForSC() {
        return teamMemberServiceCaller.getPlayersForSC();
    }*/

}
