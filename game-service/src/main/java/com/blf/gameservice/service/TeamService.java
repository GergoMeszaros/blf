package com.blf.gameservice.service;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.dao.TeamDao;
import com.blf.gameservice.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamDao teamDao;


    public List<Team> getAllTeam() {
        return teamDao.getAllTeam();
    }

    public List<Team> getAllTeamsBySeasonId(Long seasonId) {
        return teamDao.getAllTeamsBySeasonId(seasonId);
    }

    public List<Team> getTeamsByTeamName(SearchInput teamName) {
        return teamDao.getTeamsByTeamName(teamName);
    }

    public Team getTeamById(Long teamId) {
        return teamDao.getTeamById(teamId);
    }

    public List<Team> getAllBlfTeams() {
        return teamDao.getAllBlfTeams();
    }

    public Team addNewTeam(Team team) {
        return teamDao.addNewTeam(team);
    }

    public Team updateTeam(Long teamId, Team updatedTeam) {
        return teamDao.updateTeam(teamId, updatedTeam);
    }

    public Team deleteTeam(Long teamId) {
        return teamDao.deleteTeam(teamId);
    }
}
