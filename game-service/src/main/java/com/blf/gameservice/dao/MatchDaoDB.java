package com.blf.gameservice.dao;
import com.blf.gameservice.entity.Match;
import com.blf.gameservice.repository.MatchRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MatchDaoDB implements MatchDao{

    MatchRepository matchRepository;

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
}
