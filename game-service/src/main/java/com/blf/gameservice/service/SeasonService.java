package com.blf.gameservice.service;

import com.blf.gameservice.dao.SeasonDao;
import com.blf.gameservice.entity.Season;
import com.blf.gameservice.service.util.UpdateValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeasonService {

    private final SeasonDao seasonDao;
    private final UpdateValidator updateValidator;


    public List<Season> getAllSeason() {
        return seasonDao.getAllSeason();
    }

    public Season getSeasonById(Long seasonId) {
        return seasonDao.getSeasonById(seasonId);
    }

    public Season updateSeason(Long seasonId, Season updatedSeason) throws IllegalAccessException {
        Season seasonToUpdate = seasonDao.getSeasonById(seasonId);

        if (seasonToUpdate != null) {
            Season seasonToValidate = updateValidator.updater(seasonToUpdate, updatedSeason);
            seasonDao.updateSeason(seasonToValidate);
        } else {
            log.info("Season not found with the following id: " + seasonId);
        }
        return seasonToUpdate;
    }

    public Season addNewSeason(Season season) {
        return seasonDao.addNewSeason(season);
    }

    public Season deleteSeason(Long seasonId) {
        return seasonDao.deleteSeason(seasonId);
    }
}
