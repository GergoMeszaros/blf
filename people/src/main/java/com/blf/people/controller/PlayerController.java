package com.blf.people.controller;
import com.blf.people.dao.PlayerDao;
import com.blf.people.entity.Player;
import com.blf.people.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@AllArgsConstructor
@Slf4j
public class PlayerController {

    PlayerDao playerDao;

    @GetMapping("/")
    public List<Player> getAllPlayers(){
        return playerDao.getAllPlayers();
    }

    @PostMapping("/")
    public Player addPlayer(@RequestBody Player player){
        log.info("The following player is added to database: " + player);
        return playerDao.addPlayer(player);
    }
}

