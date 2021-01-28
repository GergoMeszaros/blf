package com.blf.gameservice.repository;

import com.blf.gameservice.model.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    List<TeamMember> findAllByTeamSeasonIdOrderByTeam(Long seasonId);



    @Query("SELECT teamMember FROM TeamMember AS teamMember " +
            "WHERE teamMember.player.name LIKE %:playerName%")
    List<TeamMember> findAllByPlayerName(String playerName);

}
