package com.blf.gameservice.daodb;

import com.blf.gameservice.dao.SeasonDao;
import com.blf.gameservice.entity.Season;
import com.blf.gameservice.repository.SeasonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SeasonDaoDB implements SeasonDao {

    SeasonRepository seasonRepository;

    @Override
    public List<Season> getAllSeason() {
        return seasonRepository.findAll();
    }

    @Override
    public Season getSeasonById(Long seasonId) {
        return seasonRepository.findById(seasonId).orElse(null);
    }

    @Override
    public Season updateSeason(Long seasonId, Season updatedSeason) {
        Season seasonToUpdate = seasonRepository.findById(seasonId).orElse(null);

        if (seasonToUpdate != null) {
            seasonToUpdate.setName(updatedSeason.getName() == null ? seasonToUpdate.getName() : updatedSeason.getName());

            seasonRepository.saveAndFlush(seasonToUpdate);
        } else {
            log.info("Season not found with the following id: " + seasonId);
        }
        return seasonToUpdate;
    }

    @Override
    public Season addNewSeason(Season season) {
        return seasonRepository.saveAndFlush(season);
    }

    @Override
    public Season deleteSeason(Long seasonId) {
        Season seasonToDelete = seasonRepository.findById(seasonId).orElse(null);
        seasonRepository.deleteById(seasonId);
        log.info("Deleted Season: " + seasonToDelete);
        return seasonToDelete;
    }
}
