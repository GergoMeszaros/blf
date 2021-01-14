package com.blf.gameservice.repository;

import com.blf.gameservice.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllByNameContainingIgnoreCaseOrderByName(String playerName);

}
