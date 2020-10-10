package com.blf.gameservice.controller;

import com.blf.gameservice.dao.LeagueDao;
import com.blf.gameservice.entity.League;
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

    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return leagueDao.getAllLeagues();
    }
}
