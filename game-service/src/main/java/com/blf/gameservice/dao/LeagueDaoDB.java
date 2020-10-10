package com.blf.gameservice.dao;
import com.blf.gameservice.entity.League;
import com.blf.gameservice.repository.LeagueRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class LeagueDaoDB implements LeagueDao{

    LeagueRepository leagueRepository;

    @Override
    public List<League> getAllLeague() {
        return leagueRepository.getAllLeagueJoinedSeasons();
    }
}
