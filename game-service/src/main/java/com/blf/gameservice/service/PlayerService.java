package com.blf.gameservice.service;

import com.blf.gameservice.dao.LatestSeasonDao;
import com.blf.gameservice.model.entity.Season;
import com.blf.gameservice.search.SearchInput;
import com.blf.gameservice.dao.PlayerDao;
import com.blf.gameservice.model.dto.PlayerDTO;
import com.blf.gameservice.model.entity.Player;
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
    private final LatestSeasonDao latestSeasonDao;
    private final DtoCreator<Player, PlayerDTO> dtoCreator;

    public List<PlayerDTO> getAllPlayers() {
        return dtoCreator.handleListInput(
                playerDao.getAllPlayers());
    }

    public List<PlayerDTO> getAllPlayersByName(SearchInput playerName) {
        return dtoCreator.handleListInput(
                playerDao.getAllPlayersByName(playerName));
    }

    public List<PlayerDTO> getAllLatestPlayer() {
        Long latestSeasonId = latestSeasonDao.getTheLatestSeasonId();
        return dtoCreator.handleListInput(
                playerDao.getAllLatestPlayers(latestSeasonId)
        );
    }

    public PlayerDTO getPlayerById(Long playerId) {
        return dtoCreator.handleSingleInput(
                playerDao.getPlayerById(playerId));
    }

    public PlayerDTO addPlayer(Player player) {
        player.setSeason(Season.builder()
                .id(latestSeasonDao.getTheLatestSeasonId())
                .build());

        return dtoCreator.handleSingleInput(
                playerDao.addPlayer(player));
    }

    public PlayerDTO updatePlayer(Long playerId, Player updatedPlayer) throws IllegalAccessException {
        Player playerToUpdate = playerDao.getPlayerById(playerId);

        if (playerToUpdate != null) {
            Player validatedPlayer = updateValidator.updater(playerToUpdate, updatedPlayer);
            playerDao.updatePlayer(validatedPlayer);
        } else {
            log.info("Player not found with the following id: " + playerId);
        }
        return dtoCreator.handleSingleInput(playerToUpdate);
    }

    public void deletePlayer(Long playerId) {
        playerDao.deletePlayer(playerId);
    }


}
