package com.blf.gameservice.dao;

import com.blf.gameservice.entity.Statistic;

import java.util.List;

public interface StatisticDao {

    List<Statistic> getAllStatistics();

    Statistic getStatisticById(Long statisticId);

    Statistic addNewStatistic(Statistic statistic);

    Statistic updateStatistic(Statistic updatedStatistic);

    Statistic deleteStatistic(Long statisticId);



}
