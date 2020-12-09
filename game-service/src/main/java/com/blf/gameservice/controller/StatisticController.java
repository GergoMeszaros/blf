package com.blf.gameservice.controller;

import com.blf.gameservice.entity.StatisticalRow;
import com.blf.gameservice.service.StatisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistic")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class StatisticController {

   private final StatisticService statisticService;


    @GetMapping("")
    public List<StatisticalRow> getAllStatistics() {
        return statisticService.getAllStatistics();
    }

    @GetMapping("/search/{seasonId}")
    public List<StatisticalRow> getAllStatisticsBySeasonId(@PathVariable Long seasonId) {
        return statisticService.getAllStatisticsBySeasonId(seasonId);
    }

    @GetMapping("/{statisticId}")
    public StatisticalRow getStatisticById(@PathVariable Long statisticId) {
        return statisticService.getStatisticById(statisticId);
    }

    @PostMapping("")
    public StatisticalRow addNewStatistic(@RequestBody StatisticalRow statisticalrow) {

        log.info("added statistic: " + statisticalrow);
        return statisticService.addNewStatistic(statisticalrow);
    }

   /* @PutMapping("/{statisticId}")
    public StatisticalRow editStatisticalRow(@PathVariable Long statisticId, @RequestBody StatisticalRow updatedStatisticalRow){
        return null;
    }*/

    @DeleteMapping("/{statisticId}")
    public StatisticalRow deleteStatistic(@PathVariable Long statisticId) {
        return statisticService.deleteStatistic(statisticId);
    }

}
