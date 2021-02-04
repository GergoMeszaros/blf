package com.blf.gameservice.repository;
import com.blf.gameservice.model.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeagueRepository extends JpaRepository<League, Long> {

    List<League> findAllBySeasonId(Long seasonId);

}
