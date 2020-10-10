package com.blf.gameservice.repository;
import com.blf.gameservice.entity.League;
import org.hibernate.mapping.Join;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeagueRepository extends JpaRepository<League, Long> {

  /*  @Query("SELECT league FROM League league JOIN Season season ON league.seasonId = season.id")
    List<League> getAllLeagueJoinedSeasons();*/

    List<League> findAll();
}
