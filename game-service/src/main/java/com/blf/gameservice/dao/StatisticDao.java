package com.blf.gameservice.dao;

import com.blf.gameservice.entity.StatisticalRow;

import java.util.List;

public interface StatisticDao {

    List<StatisticalRow> getAllStatistics();

    StatisticalRow getStatisticById(Long statisticId);

    StatisticalRow addNewStatistic(StatisticalRow statisticalrow);

   // StatisticalRow updateStatistic(StatisticalRow updatedStatisticalrow);

    StatisticalRow deleteStatistic(Long statisticId);



}
