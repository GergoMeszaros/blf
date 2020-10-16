package com.blf.people.daodb;

import com.blf.people.dao.PlayerDao;
import com.blf.people.dto.PlayerDTO;
import com.blf.people.entity.Player;
import com.blf.people.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerDaoDB implements PlayerDao {

    PlayerRepository playerRepository;


    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.saveAndFlush(player);
    }

    @Override
    public Player updatePlayer(Long playerId, Player updatedPlayer) {
        Player playerToUpdate = playerRepository.findById(playerId).orElse(null);

        if (playerToUpdate != null) {
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setAge(updatedPlayer.getAge());
            playerToUpdate.setBirthdate(updatedPlayer.getBirthdate());
            playerToUpdate.setBirthplace(updatedPlayer.getBirthplace());
            playerToUpdate.setHeight(updatedPlayer.getHeight());
            playerToUpdate.setIsActive(updatedPlayer.getIsActive());
            playerToUpdate.setPictureRoot(updatedPlayer.getPictureRoot());
            playerToUpdate.setPictureRootSecond(updatedPlayer.getPictureRootSecond());
            playerToUpdate.setPlayerSummary(updatedPlayer.getPlayerSummary());
            playerToUpdate.setPosition(updatedPlayer.getPosition());
            playerToUpdate.setSchool(updatedPlayer.getSchool());
            playerToUpdate.setStartDate(updatedPlayer.getStartDate());
            playerToUpdate.setTelephone(updatedPlayer.getTelephone());

            playerRepository.saveAndFlush(playerToUpdate);

            log.info("Updated Player: " + playerToUpdate);
        } else {
            log.info("Player not found with the following id: " + playerId);
        }
        return playerToUpdate;
    }

    @Override
    public Player deletePlayer(Long playerId) {
        Player playerToDelete = playerRepository.findById(playerId).orElse(null);
        playerRepository.deleteById(playerId);
        log.info("Player deleted: " + playerToDelete);
        return playerToDelete;
    }

}
