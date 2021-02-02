package com.blf.gameservice.dao;

import com.blf.gameservice.search.SearchInput;
import com.blf.gameservice.model.entity.Team;

import java.util.List;

public interface TeamDao {

    List<Team> getAllTeam();

    List<Team> getAllTeamsBySeasonId(Long seasonId);

    List<Team> getTeamsByTeamName(SearchInput team);

    List<Team> getAllBlfTeams();

    Team getTeamById(Long teamId);

    Team addNewTeam(Team team);

    void updateTeam(Team updatedTeam);

    void deleteTeam(Long teamId);

}
