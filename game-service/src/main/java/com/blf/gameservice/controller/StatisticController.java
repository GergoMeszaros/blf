package com.blf.gameservice.controller;

import com.blf.gameservice.dao.StatisticDao;
import com.blf.gameservice.entity.StatisticalRow;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/statistic")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class StatisticController {

    StatisticDao statisticDao;


    @GetMapping("")
    public List<StatisticalRow> getAllStatistics(){
        return statisticDao.getAllStatistics().stream().limit(15).collect(Collectors.toList());
    }

    @GetMapping("/{statisticId}")
    public StatisticalRow getStatisticById(@PathVariable Long statisticId){
        return statisticDao.getStatisticById(statisticId);
    }

    @PostMapping("/add")
    public StatisticalRow addNewStatistic(@RequestBody StatisticalRow statisticalrow){

        log.info("added statistic: " + statisticalrow);
        return statisticDao.addNewStatistic(statisticalrow);
    }

    @PutMapping("/edit/{statisticId}")
    public StatisticalRow editStatisticalRow(@PathVariable Long statisticId, @RequestBody StatisticalRow updatedStatisticalRow){
        return null;
    }

    @DeleteMapping("/delete/{statisticId}")
    public StatisticalRow deleteStatistic(@PathVariable Long statisticId){
        return statisticDao.deleteStatistic(statisticId);
    }

}
