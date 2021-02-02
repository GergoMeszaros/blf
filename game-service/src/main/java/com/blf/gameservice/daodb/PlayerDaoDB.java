package com.blf.gameservice.daodb;

import com.blf.gameservice.search.SearchInput;
import com.blf.gameservice.repository.PlayerRepository;
import com.blf.gameservice.dao.PlayerDao;
import com.blf.gameservice.model.entity.Player;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerDaoDB implements PlayerDao {

    private final PlayerRepository playerRepository;


    //TODO remove limiter
    @Override
    public List<Player> getAllPlayers() {
        int limiter = 30;
        return playerRepository.findAll().stream().limit(limiter).collect(Collectors.toList());
    }

    @Override
    public List<Player> getAllPlayersByName(SearchInput playerName) {
        return playerRepository.findAllByNameContainingIgnoreCaseOrderByName(playerName.getInput());
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.saveAndFlush(player);
    }

    @Override
    public void updatePlayer(Player updatedPlayer) {
        playerRepository.saveAndFlush(updatedPlayer);
    }

    @Override
    public void deletePlayer(Long playerId) {
        Player playerToDelete = playerRepository.findById(playerId).orElse(null);
        playerRepository.deleteById(playerId);
        log.info("Player deleted: " + playerToDelete);
    }
}
