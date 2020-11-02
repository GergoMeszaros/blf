package com.blf.gameservice.controller;

import com.blf.gameservice.dao.LeagueDao;
import com.blf.gameservice.entity.League;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/league")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class LeagueController {

    LeagueDao leagueDao;

    @GetMapping("")
    public List<League> getAllLeagues() {
        return leagueDao.getAllLeagues();
    }

    @PostMapping("/add")
    public League addNewLeague(@RequestBody League league){
        log.info("The following league is added to database: " + league);
        return leagueDao.addNewLeague(league);
    }

    @PutMapping("/edit/{leagueId}")
    public League editLeague(@PathVariable Long leagueId, @RequestBody League updatedLeague){
        return leagueDao.updateLeague(leagueId, updatedLeague);
    }

    @DeleteMapping("/delete/{leagueId}")
    public League deleteLeague(@PathVariable Long leagueId){
        return leagueDao.deleteLeague(leagueId);
    }

}

