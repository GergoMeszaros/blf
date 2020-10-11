package com.blf.gameservice.dao;
import com.blf.gameservice.entity.Team;
import com.blf.gameservice.repository.TeamRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TeamDaoDB implements TeamDao{

    TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }
}
