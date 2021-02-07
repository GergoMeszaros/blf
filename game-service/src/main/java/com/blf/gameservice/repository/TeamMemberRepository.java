package com.blf.gameservice.repository;

import com.blf.gameservice.model.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    List<TeamMember> findAllByTeamSeasonIdOrderByTeam(Long seasonId);

    @Transactional
    @Modifying
    @Query("DELETE FROM TeamMember teamMember WHERE " +
            "teamMember.player.id =:playerId AND " +
            "teamMember.team.id =:teamId")
    void deleteByTeamAndPlayerId(Long playerId, Long teamId);


    @Query("SELECT teamMember FROM TeamMember AS teamMember " +
            "WHERE teamMember.player.name LIKE %:playerName%")
    List<TeamMember> findAllByPlayerName(String playerName);

}
