package com.blf.gameservice.service;

import com.blf.gameservice.dao.StatisticDao;
import com.blf.gameservice.model.entity.StatisticalRow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticService {

    private final StatisticDao statisticDao;
    private final UpdateValidator updateValidator;

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

    public StatisticalRow updateStatistic(Long statisticId, StatisticalRow updatedStatistic) throws IllegalAccessException {
        StatisticalRow statisticToUpdate = statisticDao.getStatisticById(statisticId);

        if (statisticToUpdate != null) {
            StatisticalRow validatedStatistic = updateValidator.updater(statisticToUpdate, updatedStatistic);
            statisticDao.updateStatistic(validatedStatistic);
        } else {
            log.info("Statistic not found with the following id: " + statisticId);
        }
        return statisticToUpdate;
    }
}
