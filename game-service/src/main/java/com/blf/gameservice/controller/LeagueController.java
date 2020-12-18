package com.blf.gameservice.controller;

import com.blf.gameservice.entity.League;
import com.blf.gameservice.service.LeagueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/league")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class LeagueController {

    private final LeagueService leagueService;


    @GetMapping("")
    public List<League> getAllLeagues() {
        return leagueService.getAllLeagues();
    }

    @GetMapping("/{leagueId}")
    public League getLeagueById(@PathVariable Long leagueId) {
        return leagueService.getLeagueById(leagueId);
    }

    @PostMapping("/search/{seasonId}")
    public List<League> getAllLeaguesBySeason(@PathVariable Long seasonId) {
        return leagueService.getAllLeaguesBySeasonId(seasonId);
    }

    @PostMapping("")
    public League addNewLeague(@RequestBody League league) {
        log.info("The following league is added to database: " + league);
        return leagueService.addNewLeague(league);
    }

    @PutMapping("/{leagueId}")
    public League editLeague(@PathVariable Long leagueId, @RequestBody League updatedLeague) throws IllegalAccessException {
        return leagueService.updateLeague(leagueId, updatedLeague);
    }

    @DeleteMapping("/{leagueId}")
    public League deleteLeague(@PathVariable Long leagueId) {
        return leagueService.deleteLeague(leagueId);
    }

}

