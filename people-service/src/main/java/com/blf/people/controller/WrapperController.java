package com.blf.people.controller;
import com.blf.people.dto.PlayerDTO;
import com.blf.people.service.WrapperService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;
import java.util.List;

@RestController
@RequestMapping("/wrap")
@AllArgsConstructor
@Slf4j
public class WrapperController {

    WrapperService wrapperService;

    @GetMapping("")
    @ResponseBody
    public List<PlayerDTO>getAllDtoPlayers(){
        return wrapperService.getAllPlayers();
    }
}
