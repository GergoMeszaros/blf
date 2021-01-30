package com.blf.gameservice.daodb;

import com.blf.gameservice.dao.LatestSeasonDao;
import com.blf.gameservice.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LatestSeasonDaoDB implements LatestSeasonDao {

    private final SeasonRepository seasonRepository;

    @Override
    public Long getTheLatestSeasonId() {
        return seasonRepository.getTheLatestId();
    }
}
