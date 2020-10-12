package com.blf.gameservice.controller;


import com.blf.gameservice.dao.SeasonDao;
import com.blf.gameservice.entity.Season;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/season")
@AllArgsConstructor
@Slf4j
public class SeasonController {

    SeasonDao seasonDao;

    @GetMapping("")
    public List<Season> getAllSeasons() {
        return seasonDao.getAllSeason();
    }

    @PostMapping("/add")
    public Season addNewSeason(@RequestBody Season season){
        log.info("The following season is added to database: " +season);
        return seasonDao.addNewSeason(season);
    }

    @DeleteMapping("/delete/{seasonId}")
    public Season deleteSeason(@PathVariable Long seasonId){
        return seasonDao.deleteSeason(seasonId);
    }

}
