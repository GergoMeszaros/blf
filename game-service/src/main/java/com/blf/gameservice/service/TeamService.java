package com.blf.gameservice.service;

import com.blf.gameservice.search.SearchInput;
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
    private final LatestSeasonDao latestSeasonDao;
    private final UpdateValidator updateValidator;
    private final DtoCreator<Team, TeamDTO> dtoCreator;


    public List<TeamDTO> getAllTeam() {
        return dtoCreator.handleListInput(
                teamDao.getAllTeam());
    }

    public List<TeamDTO> getAllTeamsBySeasonId(Long seasonId) {
        return dtoCreator.handleListInput(
                teamDao.getAllTeamsBySeasonId(seasonId));
    }

    public List<TeamDTO> getTeamsByTeamName(SearchInput teamName) {
        return dtoCreator.handleListInput(
                teamDao.getTeamsByTeamName(teamName));
    }

    public List<TeamDTO> getAllBlfTeams() {
        return dtoCreator.handleListInput(
                teamDao.getAllBlfTeams());
    }

    public List<TeamDTO> getTeamsByTheLatestSeason() {
        Long latestSeasonId = latestSeasonDao.getTheLatestSeasonId();
        return dtoCreator.handleListInput(
                teamDao.getAllTeamsBySeasonId(latestSeasonId)
        );
    }

    public TeamDTO getTeamById(Long teamId) {
        return dtoCreator.handleSingleInput(
                teamDao.getTeamById(teamId));
    }

    public TeamDTO addNewTeam(Team team) {
        team.setSeason(Season.builder()
                .id(latestSeasonDao.getTheLatestSeasonId())
                .build());
        return dtoCreator.handleSingleInput(
                teamDao.addNewTeam(team));
    }

    public TeamDTO updateTeam(Long teamId, Team updatedTeam) throws IllegalAccessException {
        Team teamToUpdate = teamDao.getTeamById(teamId);

        if (teamToUpdate != null) {
            Team teamToValidate = updateValidator.updater(teamToUpdate, updatedTeam);
            teamDao.updateTeam(teamToValidate);
        } else {
            log.info("Team not found with the following id: " + teamId);
        }
        return dtoCreator.handleSingleInput(
                teamToUpdate);
    }

    public void deleteTeam(Long teamId) {
        teamDao.deleteTeam(teamId);
    }

}
