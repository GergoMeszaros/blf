package com.blf.gameservice.controller;


import com.blf.gameservice.dao.SeasonDao;
import com.blf.gameservice.entity.Season;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/season")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class SeasonController {

    SeasonDao seasonDao;

    @GetMapping("")
    public List<Season> getAllSeasons() {
        return seasonDao.getAllSeason();
    }

    @GetMapping("/{seasonId}")
    public Season getSeasonById(@PathVariable Long seasonId){
        return seasonDao.getSeasonById(seasonId);
    }

    @PostMapping(value = "/add")
    public Season addNewSeason(@RequestBody Season season){

        //TODO --> season object simán nem mapként
        log.info("added season: " + season);
        return seasonDao.addNewSeason(season);

       /* log.info("The following season is added to database: " +season);
        Season k = Season.builder()
                .date(season.get("date"))
                .build();
        return seasonDao.addNewSeason(k);*/
    }

    @DeleteMapping("/delete/{seasonId}")
    public Season deleteSeason(@PathVariable Long seasonId){
        return seasonDao.deleteSeason(seasonId);
    }

}
