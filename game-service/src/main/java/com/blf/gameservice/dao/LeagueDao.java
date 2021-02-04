package com.blf.gameservice.dao;

import com.blf.gameservice.model.dto.LeagueDTO;
import com.blf.gameservice.model.entity.League;

import java.util.List;

public interface LeagueDao {

    List<League> getAllLeagues();

    List<League> getAllLeaguesBySeasonId(Long seasonId);

    List<League> getLeaguesByTheLatestSeason(Long latestSeasonId);

    League getLeagueById(Long leagueId);

    League addNewLeague(League league);

    void updateLeague(League updatedLeague);

    void deleteLeague(Long leagueId);

}
