package com.blf.gameservice.service;

import com.blf.gameservice.dao.SeasonDao;
import com.blf.gameservice.entity.Season;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeasonService {

    private final SeasonDao seasonDao;


    public List<Season> getAllSeason() {
        return seasonDao.getAllSeason();
    }

    public Season getSeasonById(Long seasonId) {
        return seasonDao.getSeasonById(seasonId);
    }

    public Season updateSeason(Long seasonId, Season updatedSeason) {
        return seasonDao.updateSeason(seasonId, updatedSeason);
    }

    public Season addNewSeason(Season season) {
        return seasonDao.addNewSeason(season);
    }

    public Season deleteSeason(Long seasonId) {
        return seasonDao.deleteSeason(seasonId);
    }
}
