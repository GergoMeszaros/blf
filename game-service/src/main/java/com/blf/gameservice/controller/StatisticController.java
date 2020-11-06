package com.blf.gameservice.controller;

import com.blf.gameservice.dao.StatisticDao;
import com.blf.gameservice.entity.Season;
import com.blf.gameservice.entity.Statistic;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistic")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class StatisticController {

    StatisticDao statisticDao;


    @GetMapping("")
    public List<Statistic> getAllStatistics(){
        return statisticDao.getAllStatistics();
    }


    @GetMapping("/{statisticId}")
    public Statistic getStatisticById(@PathVariable Long statisticId){
        return statisticDao.getStatisticById(statisticId);
    }

    @PostMapping(value = "/add")
    public Statistic addNewStatistic(@RequestBody Statistic statistic){

        log.info("added statistic: " + statistic);
        return statisticDao.addNewStatistic(statistic);
    }

    @DeleteMapping("/delete/{statisticId}")
    public Statistic deleteStatistic(@PathVariable Long statisticId){
        return statisticDao.deleteStatistic(statisticId);
    }

}
