package com.blf.gameservice.service;

import com.blf.gameservice.dao.StatisticDao;
import com.blf.gameservice.entity.StatisticalRow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticService {

    private final StatisticDao statisticDao;


    public List<StatisticalRow> getAllStatistics() {
        return statisticDao.getAllStatistics();

    }

    public List<StatisticalRow> getAllStatisticsBySeasonId(Long seasonId) {
        return statisticDao.getAllStatisticsBySeasonId(seasonId);
    }

    public StatisticalRow getStatisticById(Long statisticId) {
        return statisticDao.getStatisticById(statisticId);
    }

    public StatisticalRow addNewStatistic(StatisticalRow statisticalrow) {
        return statisticDao.addNewStatistic(statisticalrow);
    }

    public StatisticalRow deleteStatistic(Long statisticId) {
        return statisticDao.deleteStatistic(statisticId);
    }
}
