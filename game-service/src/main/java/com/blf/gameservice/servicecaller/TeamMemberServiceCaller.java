package com.blf.gameservice.servicecaller;
import com.blf.gameservice.dto.PlayerDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class TeamMemberServiceCaller {

    RestTemplate restTemplate;

    @Value("http://people-service/people/player")
    private String baseUrl;


/*    public List<PlayerDTO> getPlayersForSC(){
        PlayerWrapper players = restTemplate.getForObject(baseUrl, PlayerWrapper.class);
        System.out.println(players);
        log.info("OBJECTS: " + players);
        return players.getPlayers();
    }*/
}
