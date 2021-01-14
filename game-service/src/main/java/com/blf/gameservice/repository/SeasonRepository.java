package com.blf.gameservice.repository;

import com.blf.gameservice.model.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
