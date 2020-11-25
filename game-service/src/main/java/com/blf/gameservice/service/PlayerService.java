package com.blf.gameservice.service;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.dao.PlayerDao;
import com.blf.gameservice.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerDao playerDao;


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

    public Player updatePlayer(Long playerId, Player player) {
        return playerDao.updatePlayer(playerId, player);
    }

    public Player deletePlayer(Long playerId) {
        return playerDao.deletePlayer(playerId);
    }
}
