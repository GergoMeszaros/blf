package com.blf.gameservice.dao;
import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.entity.Team;

import java.util.List;

public interface TeamDao {

    List<Team> getAllTeam();

    List<Team> getAllTeamsBySeasonId(Long seasonId);

    List<Team> getTeamsByTeamName(SearchInput team);

    List<Team> getAllBlfTeams();

    Team getTeamById(Long teamId);

    Team addNewTeam(Team team);

    Team updateTeam(Long teamId, Team updatedTeam);

    Team deleteTeam(Long teamId);

}
