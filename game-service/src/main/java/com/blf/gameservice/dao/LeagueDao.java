package com.blf.gameservice.dao;

import com.blf.gameservice.entity.League;

import java.util.List;

public interface LeagueDao {

    List<League> getAllLeagues();

    List<League> getAllLeaguesBySeasonId(Long seasonId);

    League getLeagueById(Long leagueId);

    League addNewLeague(League league);

    void updateLeague(League updatedLeague);

    League deleteLeague(Long leagueId);

}
