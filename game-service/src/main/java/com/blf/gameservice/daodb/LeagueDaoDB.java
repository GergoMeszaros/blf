package com.blf.gameservice.daodb;

import com.blf.gameservice.dao.LeagueDao;
import com.blf.gameservice.entity.League;
import com.blf.gameservice.repository.LeagueRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class LeagueDaoDB implements LeagueDao {

    LeagueRepository leagueRepository;

    @Override
    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    @Override
    public League addNewLeague(League league) {
        return leagueRepository.saveAndFlush(league);
    }

    @Override
    public League updateLeague(Long leagueId, League updatedLeague) {
        League leagueToUpdate = leagueRepository.findById(leagueId).orElse(null);

        if (leagueToUpdate != null) {
            leagueToUpdate.setName(updatedLeague.getName());
            leagueToUpdate.setAgeGroupId(updatedLeague.getAgeGroupId());
            leagueToUpdate.setOrganization(updatedLeague.getOrganization());
            leagueToUpdate.setSeasonId(updatedLeague.getSeasonId());

            leagueRepository.saveAndFlush(leagueToUpdate);
        } else {
            log.info("League not found with the following id: " + leagueId);
        }
        return leagueToUpdate;
    }

    @Override
    public League deleteLeague(Long leagueId) {
        League leagueToDelete = leagueRepository.findById(leagueId).orElse(null);
        if(leagueToDelete != null) {
            leagueRepository.delete(leagueToDelete);
        }
        log.info("League deleted: " + leagueToDelete);
        return leagueToDelete;
    }

}
