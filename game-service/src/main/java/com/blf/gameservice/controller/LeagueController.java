package com.blf.gameservice.controller;

import com.blf.gameservice.model.dto.LeagueDTO;
import com.blf.gameservice.model.entity.League;
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


 /*   @GetMapping("")
    public List<LeagueDTO> getAllLeagues() {
        return leagueService.getAllLeagues();
    }
*/
    @GetMapping("")
    public List<LeagueDTO> getAllLatestLeague(){
        return leagueService.getLeaguesByTheLatestSeason();
    }

    @GetMapping("/{leagueId}")
    public LeagueDTO getLeagueById(@PathVariable Long leagueId) {
        return leagueService.getLeagueById(leagueId);
    }

    @GetMapping("/latestSeason")
    public List<LeagueDTO> getLeaguesByTheLatestSeason(){
        return leagueService.getLeaguesByTheLatestSeason();
    }

    @PostMapping("/search/{seasonId}")
    public List<LeagueDTO> getAllLeaguesBySeason(@PathVariable Long seasonId) {
        return leagueService.getAllLeaguesBySeasonId(seasonId);
    }

    @PostMapping("")
    public LeagueDTO addNewLeague(@RequestBody League league) {
        log.info("The following league is added to database: " + league);
        return leagueService.addNewLeague(league);
    }

    @PutMapping("/{leagueId}")
    public LeagueDTO editLeague(@PathVariable Long leagueId, @RequestBody League updatedLeague) throws IllegalAccessException {
        return leagueService.updateLeague(leagueId, updatedLeague);
    }

    @DeleteMapping("/{leagueId}")
    public void deleteLeague(@PathVariable Long leagueId) {
         leagueService.deleteLeague(leagueId);
    }

}

