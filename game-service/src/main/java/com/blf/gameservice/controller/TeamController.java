package com.blf.gameservice.controller;

import com.blf.gameservice.search.SearchInput;
import com.blf.gameservice.model.dto.TeamDTO;
import com.blf.gameservice.model.entity.Team;
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

    @GetMapping("")
    public List<TeamDTO> getAllTeam() {
        return teamService.getAllTeam();
    }

    @GetMapping("/{teamId}")
    public TeamDTO getTeamById(@PathVariable Long teamId) {
        return teamService.getTeamById(teamId);
    }

    @GetMapping("/blfteams")
    public List<TeamDTO> getALlBflTeams() {
        return teamService.getAllBlfTeams();
    }

    @PostMapping("/search/{seasonId}")
    public List<TeamDTO> getAllTeamsBySeason(@PathVariable Long seasonId) {
        return teamService.getAllTeamsBySeasonId(seasonId);
    }

    @PostMapping("/search")
    public List<TeamDTO> getTeamsByTeamName(@RequestBody SearchInput teamName) {
        return teamService.getTeamsByTeamName(teamName);
    }

    @PostMapping("")
    public TeamDTO addNewTeam(@RequestBody Team team) {
        return teamService.addNewTeam(team);
    }

    @PutMapping("/{teamId}")
    public TeamDTO updateTeam(@PathVariable Long teamId, @RequestBody Team updatedTeam) throws IllegalAccessException {
        return teamService.updateTeam(teamId, updatedTeam);
    }

    @DeleteMapping("/{teamId}")
    public void deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeam(teamId);
    }


}
