package com.blf.gameservice.service;

import com.blf.gameservice.model.dto.BaseDTO;
import com.blf.gameservice.model.dto.LeagueDTO;
import com.blf.gameservice.model.dto.Wrapper;
import com.blf.gameservice.model.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DtoCreator<Type extends BaseEntity, DtoType extends BaseDTO> {

   /* private final ModelMapper modelMapper;

    private final List<Class> dtoClassList = Collections.singletonList(LeagueDTO.class);

    private Class<DtoType> decideWhichDTOtoUse(){
        return dtoClassList.get(0);
    }


  *//*  public PlayerWrapper getAllPlayers() {
        List<PlayerDTO> playerDTOList =
                playerRepository
                        .findAll()
                        .stream().map(this::convertPlayerToPlayerDto)
                        .collect(Collectors.toList());
        return new PlayerWrapper(playerDTOList);
    }*//*

   *//* private PlayerDTO convertPlayerToPlayerDto(Player player) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(player, PlayerDTO.class);
*//*


    public Wrapper<DtoType> wrapInput(List<Type> entityList) {
        List<DtoType> dtos = entityList.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
        return new Wrapper<>(dtos);
    }


    private DtoType convertEntityToDTO(Type entity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(entity, decideWhichDTOtoUse());
    }*/
}
