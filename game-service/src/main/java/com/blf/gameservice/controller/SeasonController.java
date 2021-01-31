package com.blf.gameservice.controller;

import com.blf.gameservice.model.dto.SeasonDTO;
import com.blf.gameservice.model.entity.Season;
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
    public List<SeasonDTO> getAllSeasons() {
        return seasonService.getAllSeason();
    }

    @GetMapping("/{seasonId}")
    public SeasonDTO getSeasonById(@PathVariable Long seasonId) {
        return seasonService.getSeasonById(seasonId);
    }

    @PutMapping("/{seasonId}")
    public SeasonDTO editSeason(@PathVariable Long seasonId, @RequestBody Season updatedSeason) throws IllegalAccessException {
        return seasonService.updateSeason(seasonId, updatedSeason);
    }

    @PostMapping("")
    public SeasonDTO addNewSeason() {
        return seasonService.addNewSeason();
    }

    @DeleteMapping("/{seasonId}")
    public SeasonDTO deleteSeason(@PathVariable Long seasonId) {
        return seasonService.deleteSeason(seasonId);
    }

}
