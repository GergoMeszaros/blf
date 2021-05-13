package com.blf.gameservice.service;

import com.blf.gameservice.model.dto.*;
import com.blf.gameservice.model.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DtoCreator<Type extends BaseEntity, DtoType extends BaseDTO> {

    private final ModelMapper modelMapper;


    public DtoType handleSingleInput(Type entity) {
        return entity == null ? null : convertEntityToDTO(entity);
    }

    public List<DtoType> handleListInput(List<Type> entityList) {
        return entityList.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private DtoType convertEntityToDTO(Type entity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(entity, decideWhichDTOtoUse(entity));
    }

    private Class<DtoType> decideWhichDTOtoUse(Type entity) {

        String className = entity.getClass().getSimpleName();
        Class targetClass = null;

        try {
            targetClass = Class.forName("com.blf.gameservice.model.dto." + className + "DTO");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return targetClass;
    }

}
