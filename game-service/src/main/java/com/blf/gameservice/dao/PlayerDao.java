package com.blf.gameservice.dao;

import com.blf.gameservice.search.SearchInput;
import com.blf.gameservice.model.entity.Player;

import java.util.List;

public interface PlayerDao {

    List<Player> getAllPlayers();

    List<Player> getAllPlayersByName(SearchInput playerName);

    Player getPlayerById(Long id);

    Player addPlayer(Player player);

    void updatePlayer(Player player);

    void deletePlayer(Long id);

}
