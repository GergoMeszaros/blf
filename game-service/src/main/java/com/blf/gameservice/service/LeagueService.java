package com.blf.gameservice.service;

import com.blf.gameservice.dao.LeagueDao;
import com.blf.gameservice.entity.League;

import java.util.List;

public class LeagueService {

    LeagueDao leagueDao;

    public List<League> getAllLeagues() {
        return leagueDao.getAllLeagues();
    }

    public List<League> getAllLeaguesBySeasonId(Long seasonId) {
        return leagueDao.getAllLeaguesBySeasonId(seasonId);
    }

    public League getLeagueById(Long leagueId) {
        return leagueDao.getLeagueById(leagueId);
    }

    public League addNewLeague(League league) {
        return leagueDao.addNewLeague(league);
    }

    public League updateLeague(Long leagueId, League updatedLeague) {
        return leagueDao.updateLeague(leagueId, updatedLeague);
    }

    public League deleteLeague(Long leagueId) {
        return leagueDao.deleteLeague(leagueId);
    }
}
