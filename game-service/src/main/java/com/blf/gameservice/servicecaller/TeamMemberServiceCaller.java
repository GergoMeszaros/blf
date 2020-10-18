package com.blf.gameservice.servicecaller;
import com.blf.gameservice.dto.PlayerDTO;
import com.blf.gameservice.dto.PlayerWrapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamMemberServiceCaller {

   private final RestTemplate restTemplate;

    @Value("http://localhost:8762/people/wrapper")
    private String baseUrl;

    public List<PlayerDTO> getPlayersForSC(){
        PlayerWrapper players = restTemplate.getForObject(baseUrl, PlayerWrapper.class);
        assert players != null;
        return players.getPlayerDTOS();
    }
}
