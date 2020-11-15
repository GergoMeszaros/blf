package com.blf.people.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@AllArgsConstructor
public class WrapperService {

  /*  PlayerRepository playerRepository;

    ModelMapper modelMapper;

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
                .map(player, PlayerDTO.class);
    }*/
}
