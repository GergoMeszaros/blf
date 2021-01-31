package com.blf.gameservice.service;

import com.blf.gameservice.dao.SeasonDao;
import com.blf.gameservice.model.dto.SeasonDTO;
import com.blf.gameservice.model.entity.Season;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeasonService {

    private final SeasonDao seasonDao;
    private final UpdateValidator updateValidator;
    private final DtoCreator<Season, SeasonDTO> dtoCreator;

    public List<SeasonDTO> getAllSeason() {
        return dtoCreator.handleListInput(
                seasonDao.getAllSeason());
    }

    public SeasonDTO getSeasonById(Long seasonId) {
        return dtoCreator.handleSingleInput(
                seasonDao.getSeasonById(seasonId));
    }

    public SeasonDTO updateSeason(Long seasonId, Season updatedSeason) throws IllegalAccessException {
        Season seasonToUpdate = seasonDao.getSeasonById(seasonId);

        if (seasonToUpdate != null) {
            Season seasonToValidate = updateValidator.updater(seasonToUpdate, updatedSeason);
            seasonDao.updateSeason(seasonToValidate);
        } else {
            log.info("Season not found with the following id: " + seasonId);
        }
        return dtoCreator.handleSingleInput(seasonToUpdate);
    }

    public SeasonDTO addNewSeason() {
        int currentYear = LocalDate.now().getYear();
        LocalDate dateOfNewSeason = LocalDate.of(currentYear, Month.JULY, 30);
        boolean canNewSeasonBeAdded = LocalDate.now().isAfter(dateOfNewSeason);

        String newSeasonName = currentYear + "-" + currentYear + 1;

        if (!seasonNameChecker(newSeasonName) && canNewSeasonBeAdded) {
            Season newSeason = Season.builder()
                    .name(newSeasonName)
                    .build();
            return dtoCreator.handleSingleInput(
                    seasonDao.addNewSeason(newSeason));
        } else {
            return null;
        }
    }

    public SeasonDTO deleteSeason(Long seasonId) {
        return dtoCreator.handleSingleInput(
                seasonDao.deleteSeason(seasonId));
    }

    private boolean seasonNameChecker(String seasonName) {
        List<Season> seasons = seasonDao.getAllSeason();

        return seasons.stream()
                .anyMatch(season -> seasonName.equals(season.getName()));
    }

}
