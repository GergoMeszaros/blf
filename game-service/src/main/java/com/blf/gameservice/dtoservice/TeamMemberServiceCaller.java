package com.blf.gameservice.dtoservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamMemberServiceCaller {


  /*  ModelMapper modelMapper;

    public PlayerWrapper getAllPlayers() {
        List<PlayerDTO> playerDTOList =
                playerRepository
                        .findAll()
                        .stream().map(this::convertPlayerToPlayerDto)
                        .collect(Collectors.toList());
        return new PlayerWrapper(playerDTOList);
    }

    private PlayerDTO convertPlayerToPlayerDto(Player player) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(player, PlayerDTO.class);*/

}
