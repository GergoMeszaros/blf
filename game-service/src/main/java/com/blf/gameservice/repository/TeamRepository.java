package com.blf.gameservice.repository;
import com.blf.gameservice.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamRepository extends JpaRepository<Team, Long> {
}
