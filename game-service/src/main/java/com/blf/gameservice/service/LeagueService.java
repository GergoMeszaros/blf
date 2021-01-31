package com.blf.gameservice.service;

import com.blf.gameservice.dao.LatestSeasonDao;
import com.blf.gameservice.dao.LeagueDao;
import com.blf.gameservice.model.dto.LeagueDTO;
import com.blf.gameservice.model.entity.League;
import com.blf.gameservice.model.entity.Season;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeagueService {

    private final LeagueDao leagueDao;
    private final LatestSeasonDao latestSeasonDao;
    private final UpdateValidator updateValidator;
    private final DtoCreator<League, LeagueDTO> dtoCreator;


    public List<LeagueDTO> getAllLeagues() {
        return dtoCreator.handleListInput(
                leagueDao.getAllLeagues());
    }

    public List<LeagueDTO> getAllLeaguesBySeasonId(Long seasonId) {
        return dtoCreator.handleListInput(
                leagueDao.getAllLeaguesBySeasonId(seasonId));

    }

    public LeagueDTO getLeagueById(Long leagueId) {
        return dtoCreator.handleSingleInput(
                leagueDao.getLeagueById(leagueId));
    }

    public LeagueDTO addNewLeague(League league) {
        league.setSeason(Season.builder()
                .id(latestSeasonDao.getTheLatestSeasonId())
                .build());
        return dtoCreator.handleSingleInput(
                leagueDao.addNewLeague(league));
    }

    public LeagueDTO updateLeague(Long leagueId, League updatedLeague) throws IllegalAccessException {
        League leagueToUpdate = leagueDao.getLeagueById(leagueId);

        if (leagueToUpdate != null) {
            League validatedLeague = updateValidator.updater(leagueToUpdate, updatedLeague);
            leagueDao.updateLeague(validatedLeague);
        } else {
            log.info("League not found with the following id: " + leagueId);
        }
        return dtoCreator.handleSingleInput(leagueToUpdate);
    }

    public LeagueDTO deleteLeague(Long leagueId) {
        return dtoCreator.handleSingleInput(leagueDao.deleteLeague(leagueId));
    }
}
