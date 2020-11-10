package com.blf.people.service;

import com.blf.people.dto.PlayerDTO;
import com.blf.people.dto.PlayerWrapper;
import com.blf.people.entity.Player;
import com.blf.people.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class WrapperService {

    PlayerRepository playerRepository;

    ModelMapper modelMapper;

    public PlayerWrapper getAllPlayers() {
        List<PlayerDTO> playerDTOList =
                playerRepository
                        .findAll()
                        .stream().map(this::convertPlayerToPlayerDto)
                        .collect(Collectors.toList());
        return new PlayerWrapper(playerDTOList);
    }

    private PlayerDTO convertPlayerToPlayerDto(Player user) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(user, PlayerDTO.class);
    }
}
