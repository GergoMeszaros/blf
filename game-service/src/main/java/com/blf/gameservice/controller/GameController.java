package com.blf.gameservice.controller;
import com.blf.gameservice.dao.LeagueDao;
import com.blf.gameservice.dao.MatchDao;
import com.blf.gameservice.dao.SeasonDao;
import com.blf.gameservice.entity.League;
import com.blf.gameservice.entity.Match;
import com.blf.gameservice.entity.Season;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
@AllArgsConstructor
@Slf4j
public class GameController {

    LeagueDao leagueDao;
    SeasonDao seasonDao;
    MatchDao matchDao;

    @GetMapping("/seasons")
    public List<Season> getAllSeasons() {
        return seasonDao.getAllSeason();
    }

    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return leagueDao.getAllLeagues();
    }

    @GetMapping("/matches")
    public List<Match> getAllMatches(){
        return matchDao.getAllMatches();
    }
}
