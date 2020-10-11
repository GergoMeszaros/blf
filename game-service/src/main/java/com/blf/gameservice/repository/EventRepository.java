package com.blf.gameservice.repository;
import com.blf.gameservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event, Long>{

}
