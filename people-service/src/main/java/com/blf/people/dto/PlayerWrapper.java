package com.blf.people.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlayerWrapper {

    List<PlayerDTO> playerDTOS;
}
