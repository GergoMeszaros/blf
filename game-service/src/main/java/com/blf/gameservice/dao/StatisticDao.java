package com.blf.gameservice.dao;

import com.blf.gameservice.entity.StatisticalRow;

import java.util.List;

public interface StatisticDao {

    List<StatisticalRow> getAllStatistics();

    List<StatisticalRow> getAllStatisticsBySeasonId(Long seasonId);

    StatisticalRow getStatisticById(Long statisticId);

    StatisticalRow addNewStatistic(StatisticalRow statisticalrow);

    void updateStatistic(StatisticalRow updatedStatisticalRow);

    StatisticalRow deleteStatistic(Long statisticId);



}
