package com.blf.gameservice.daodb;

import com.blf.gameservice.dao.StatisticDao;
import com.blf.gameservice.entity.Statistic;
import com.blf.gameservice.repository.StatisticRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class StatisticDaoDB implements StatisticDao {

    StatisticRepository statisticRepository;

    @Override
    public List<Statistic> getAllStatistics() {
        return statisticRepository.findAll();
    }

    @Override
    public Statistic getStatisticById(Long statisticId) {
        return statisticRepository.findById(statisticId).orElse(null);
    }

    @Override
    public Statistic addNewStatistic(Statistic statistic) {
        return statisticRepository.saveAndFlush(statistic);
    }

    @Override
    public Statistic updateStatistic(Statistic updatedStatistic) {
        return null;
    }

    @Override
    public Statistic deleteStatistic(Long statisticId) {
        Statistic statToDelete = statisticRepository.findById(statisticId).orElse(null);
        statisticRepository.deleteById(statisticId);
        log.info("Deleted statistic: " + statToDelete);
        return statToDelete;
    }
}
