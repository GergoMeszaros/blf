package com.blf.gameservice.controller;

import com.blf.gameservice.entity.Season;
import com.blf.gameservice.service.SeasonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/season")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class SeasonController {

    private final SeasonService seasonService;


    @GetMapping("")
    public List<Season> getAllSeasons() {
        return seasonService.getAllSeason();
    }

    @GetMapping("/{seasonId}")
    public Season getSeasonById(@PathVariable Long seasonId) {
        return seasonService.getSeasonById(seasonId);
    }

    @PutMapping("/{seasonId}")
    public Season editSeason(@PathVariable Long seasonId, @RequestBody Season updatedSeason) {
        return seasonService.updateSeason(seasonId, updatedSeason);
    }

    @PostMapping("/")
    public Season addNewSeason(@RequestBody Season season) {

        //TODO --> season object simán nem mapként
        log.info("added season: " + season);
        return seasonService.addNewSeason(season);

    }

    @DeleteMapping("/{seasonId}")
    public Season deleteSeason(@PathVariable Long seasonId) {
        return seasonService.deleteSeason(seasonId);
    }

}
