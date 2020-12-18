package com.blf.gameservice.daodb;

import com.blf.gameservice.dao.LeagueDao;
import com.blf.gameservice.entity.League;
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
    public League deleteLeague(Long leagueId) {
        League leagueToDelete = leagueRepository.findById(leagueId).orElse(null);
        if (leagueToDelete != null) {
            leagueRepository.delete(leagueToDelete);
        }
        log.info("League deleted: " + leagueToDelete);
        return leagueToDelete;
    }

}
