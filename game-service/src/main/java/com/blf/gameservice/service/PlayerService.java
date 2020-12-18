package com.blf.gameservice.service;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.dao.PlayerDao;
import com.blf.gameservice.entity.Player;
import com.blf.gameservice.service.util.UpdateValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService {

    private final PlayerDao playerDao;
    private final UpdateValidator updateValidator;


    public List<Player> getAllPlayers() {
        return playerDao.getAllPlayers();
    }

    public List<Player> getAllPlayersByName(SearchInput playerName) {
        return playerDao.getAllPlayersByName(playerName);
    }

    public Player getPlayerById(Long playerId) {
        return playerDao.getPlayerById(playerId);
    }

    public Player addPlayer(Player player) {
        return playerDao.addPlayer(player);
    }

    public Player updatePlayer(Long playerId, Player updatedPlayer) throws IllegalAccessException {
        Player playerToUpdate = playerDao.getPlayerById(playerId);

        if (playerToUpdate != null) {
            Player validatedPlayer = updateValidator.updater(playerToUpdate, updatedPlayer);
            playerDao.updatePlayer(validatedPlayer);
        } else {
            log.info("Player not found with the following id: " + playerId);
        }
        return playerToUpdate;
    }

    public Player deletePlayer(Long playerId) {
        return playerDao.deletePlayer(playerId);
    }
}
