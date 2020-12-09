package com.blf.gameservice.controller;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.dao.PlayerDao;
import com.blf.gameservice.entity.Player;
import com.blf.gameservice.service.PlayerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class PlayerController {

   private final PlayerService playerService;


    /* @GetMapping("/paginated/{page}")
     public Page<Player> getPaginatedPlayers(@PathVariable int page) {
         return playerDao.getAllPaginatedPlayers(page);
     }
 */
    @GetMapping("")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping("/search")
    public List<Player> getAllPlayersByName(@RequestBody SearchInput playerName) {
        return playerService.getAllPlayersByName(playerName);
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable Long playerId) {
        return playerService.getPlayerById(playerId);
    }

    @PostMapping("")
    public Player addPlayer(@RequestBody Player player) {
        log.info("The following player is added to database: " + player);
        return playerService.addPlayer(player);
    }

    @PutMapping("/{playerId}")
    public Player updatePlayer(@PathVariable Long playerId, @RequestBody Player player) {
        return playerService.updatePlayer(playerId, player);
    }

    @DeleteMapping("/{playerId}")
    public Player deletePlayer(@PathVariable Long playerId) {
        return playerService.deletePlayer(playerId);
    }

}

