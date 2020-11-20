package com.blf.gameservice.repository;

import com.blf.gameservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllBySeasonId(Long seasonId);

    @Query("SELECT event FROM Event AS event " +
            "WHERE event.homeTeam.name LIKE %:input% " +
            "OR event.awayTeam.name LIKE %:input% " +
            "OR event.address LIKE %:input% " +
            "OR event.league.name LIKE %:input%")
    List<Event> findAllBySearch(String input);
}
