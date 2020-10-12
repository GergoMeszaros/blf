package com.blf.gameservice.dao;
import com.blf.gameservice.entity.Season;
import java.util.List;

public interface SeasonDao {

    List<Season> getAllSeason();

    Season addNewSeason(Season season);

    Season deleteSeason(Long seasonId);
}
