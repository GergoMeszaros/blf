package com.blf.people.daodb;

import com.blf.people.dao.PlayerDao;
import com.blf.people.entity.Player;
import com.blf.people.repository.PlayerPaginationRepository;
import com.blf.people.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerDaoDB implements PlayerDao {

    PlayerRepository playerRepository;
    PlayerPaginationRepository paginationRepository;


    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll().stream().limit(15).collect(Collectors.toList());
    }

    @Override
    public Page<Player> getAllPaginatedPlayers(int page) {
        Pageable pageable = PageRequest.of(page,30);
        return paginationRepository.findAll(pageable);
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
