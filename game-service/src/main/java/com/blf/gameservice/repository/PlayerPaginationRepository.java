package com.blf.gameservice.repository;


import com.blf.gameservice.entity.Player;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayerPaginationRepository extends PagingAndSortingRepository<Player, Long> {



}
