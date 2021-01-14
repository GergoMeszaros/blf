package com.blf.gameservice.repository;

import com.blf.gameservice.model.entity.StatisticalRow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatisticalRowRepository extends JpaRepository<StatisticalRow, Long> {

    List<StatisticalRow> findAllByPlayerSeasonId(Long seasonId);
}
