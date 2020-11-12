package com.blf.gameservice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Component
@Data
@RequiredArgsConstructor
public class TeamMemberDTO {

    @GeneratedValue
    @Id
    private Long id;

    private String playerName;
    private Integer playerId;

    private String teamName;
    private String seasonName;

    private Integer tmPlayerId;
    private Integer tmTeamId;


}
