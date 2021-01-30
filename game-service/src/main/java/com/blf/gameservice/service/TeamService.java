package com.blf.gameservice.service;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.dao.LatestSeasonDao;
import com.blf.gameservice.dao.TeamDao;
import com.blf.gameservice.model.dto.TeamDTO;
import com.blf.gameservice.model.entity.Season;
import com.blf.gameservice.model.entity.Team;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {

    private final TeamDao teamDao;
    private final UpdateValidator updateValidator;
    private final LatestSeasonDao latestSeasonDao;
    private final DtoCreator<Team, TeamDTO> dtoCreator;


    public List<TeamDTO> getAllTeam() {
        return dtoCreator.handleInput(teamDao.getAllTeam());
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
        team.setSeason(Season.builder()
                .id(latestSeasonDao.getTheLatestSeasonId())
                .build());
        return teamDao.addNewTeam(team);
    }

    public Team updateTeam(Long teamId, Team updatedTeam) throws IllegalAccessException {
        Team teamToUpdate = teamDao.getTeamById(teamId);

        if (teamToUpdate != null) {
            Team teamToValidate = updateValidator.updater(teamToUpdate, updatedTeam);
            teamDao.updateTeam(teamToValidate);
        } else {
            log.info("Team not found with the following id: " + teamId);
        }
        return teamToUpdate;
    }

    public Team deleteTeam(Long teamId) {
        return teamDao.deleteTeam(teamId);
    }

}
