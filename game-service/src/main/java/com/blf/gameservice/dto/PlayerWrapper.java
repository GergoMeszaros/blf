package com.blf.gameservice.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@RequiredArgsConstructor
public class PlayerWrapper {

   private List<PlayerDTO> playerDTOS;
}
