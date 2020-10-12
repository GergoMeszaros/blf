package com.blf.gameservice.repository;
import com.blf.gameservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long>{

    @Query("SELECT event FROM Event AS event WHERE event.homeTeamId = :teamId OR event.awayTeamId = :teamId")
     List<Event> getEventsByAnyTeamId(@Param("teamId") Integer teamId);



}
