package com.blf.gameservice.controller;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.entity.Player;
import com.blf.gameservice.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class PlayerController {

   private final PlayerService playerService;

    @GetMapping("")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable Long playerId) {
        return playerService.getPlayerById(playerId);
    }

    @PostMapping("/search")
    public List<Player> getAllPlayersByName(@RequestBody SearchInput playerName) {
        return playerService.getAllPlayersByName(playerName);
    }

    @PostMapping("")
    public Player addPlayer(@RequestBody Player player) {
        log.info("The following player is added to database: " + player);
        return playerService.addPlayer(player);
    }

    @PutMapping("/{playerId}")
    public Player updatePlayer(@PathVariable Long playerId, @RequestBody Player player) throws IllegalAccessException {
        return playerService.updatePlayer(playerId, player);
    }

    @DeleteMapping("/{playerId}")
    public Player deletePlayer(@PathVariable Long playerId) {
        return playerService.deletePlayer(playerId);
    }

}

