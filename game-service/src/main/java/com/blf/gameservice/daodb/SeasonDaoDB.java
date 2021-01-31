package com.blf.gameservice.daodb;

import com.blf.gameservice.dao.SeasonDao;
import com.blf.gameservice.model.entity.Season;
import com.blf.gameservice.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeasonDaoDB implements SeasonDao {

    private final SeasonRepository seasonRepository;


    @Override
    public List<Season> getAllSeason() {
        return seasonRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Season getSeasonById(Long seasonId) {
        return seasonRepository.findById(seasonId).orElse(null);
    }

    @Override
    public void updateSeason(Season updatedSeason) {
        seasonRepository.saveAndFlush(updatedSeason);
    }

    @Override
    public Season addNewSeason(Season season) {
        return seasonRepository.saveAndFlush(season);
    }

    @Override
    public void deleteSeason(Long seasonId) {
        Season seasonToDelete = seasonRepository.findById(seasonId).orElse(null);
        seasonRepository.deleteById(seasonId);
        log.info("Deleted Season: " + seasonToDelete);
    }
}
