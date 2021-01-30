package com.blf.gameservice.repository;

import com.blf.gameservice.model.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeasonRepository extends JpaRepository<Season, Long> {

    @Query("SELECT MAX(id) FROM Season")
    Long getTheLatestId();
}
