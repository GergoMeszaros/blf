package com.blf.people.repository;

import com.blf.people.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface PlayerPaginationRepository extends PagingAndSortingRepository<Player, Long> {



}
