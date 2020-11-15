package com.blf.gameservice.controller;

import com.blf.gameservice.dao.PlayerDao;
import com.blf.gameservice.entity.Player;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class PlayerController {

    PlayerDao playerDao;

    @GetMapping("/paginated/{page}")
    public Page<Player> getPaginatedPlayers(@PathVariable int page) {
        return playerDao.getAllPaginatedPlayers(page);
    }

    @GetMapping("")
    public List<Player> getAllPlayers() {
        return playerDao.getAllPlayers();
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable Long playerId) {
        return playerDao.getPlayerById(playerId);
    }

    @PostMapping("/add")
    public Player addPlayer(@RequestBody Player player) {
        log.info("The following player is added to database: " + player);
        return playerDao.addPlayer(player);
    }

    @PutMapping("/edit/{playerId}")
    public Player updatePlayer(@PathVariable Long playerId, @RequestBody Player player) {
        return playerDao.updatePlayer(playerId, player);
    }

    @DeleteMapping("/delete/{playerId}")
    public Player deletePlayer(@PathVariable Long playerId) {
        return playerDao.deletePlayer(playerId);
    }

}

