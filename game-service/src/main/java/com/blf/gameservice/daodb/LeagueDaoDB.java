package com.blf.gameservice.daodb;

import com.blf.gameservice.dao.LeagueDao;
import com.blf.gameservice.model.dto.LeagueDTO;
import com.blf.gameservice.model.entity.League;
import com.blf.gameservice.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeagueDaoDB implements LeagueDao {

    private final LeagueRepository leagueRepository;


    @Override
    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    @Override
    public List<League> getAllLeaguesBySeasonId(Long seasonId) {
        return leagueRepository.findAllBySeasonId(seasonId);
    }

    @Override
    public List<League> getLeaguesByTheLatestSeason(Long latestSeasonId) {
        return leagueRepository.findAllBySeasonId(latestSeasonId);
    }

    @Override
    public League getLeagueById(Long leagueId) {
        return leagueRepository.findById(leagueId).orElse(null);
    }

    @Override
    public League addNewLeague(League league) {
        return leagueRepository.saveAndFlush(league);
    }

    @Override
    public void updateLeague(League updatedLeague) {
        leagueRepository.saveAndFlush(updatedLeague);
    }

    @Override
    public void deleteLeague(Long leagueId) {
        League leagueToDelete = leagueRepository.findById(leagueId).orElse(null);
        if (leagueToDelete != null) {
            leagueRepository.delete(leagueToDelete);
        }
        log.info("League deleted: " + leagueToDelete);
    }

}
