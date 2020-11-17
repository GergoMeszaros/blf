package com.blf.gameservice.repository;

import com.blf.gameservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllBySeasonId(Long seasonId);
}
