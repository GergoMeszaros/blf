package com.blf.gameservice.dao;
import com.blf.gameservice.entity.League;
import java.util.List;

public interface LeagueDao {

    List<League> getAllLeagues();

    League getLeagueById(Long leagueId);

    League addNewLeague(League league);

    League updateLeague(Long leagueId, League updatedLeague);

    League deleteLeague(Long leagueId);

}
