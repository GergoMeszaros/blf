package com.blf.gameservice.service;

import com.blf.gameservice.dao.LeagueDao;
import com.blf.gameservice.entity.League;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeagueService {

    private final LeagueDao leagueDao;
    private final UpdateValidator updateValidator;


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

    public League updateLeague(Long leagueId, League updatedLeague) throws IllegalAccessException {
        League leagueToUpdate = leagueDao.getLeagueById(leagueId);

        if (leagueToUpdate != null) {
            League validatedLeague = updateValidator.updater(leagueToUpdate, updatedLeague);
            leagueDao.updateLeague(validatedLeague);
        } else {
            log.info("League not found with the following id: " + leagueId);
        }
        return leagueToUpdate;
    }

    public League deleteLeague(Long leagueId) {
        return leagueDao.deleteLeague(leagueId);
    }
}
