package com.blf.people.dao;
import com.blf.people.entity.Player;
import com.blf.people.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerDaoDB implements PlayerDao{

    PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.saveAndFlush(player);
    }
}
