package com.blf.gameservice.repository;
import com.blf.gameservice.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
