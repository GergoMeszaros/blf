package com.blf.gameservice.repository;

import com.blf.gameservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {


}
