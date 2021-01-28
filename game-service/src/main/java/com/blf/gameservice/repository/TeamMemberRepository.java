package com.blf.gameservice.repository;

import com.blf.gameservice.model.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    List<TeamMember> findAllByTeamSeasonIdOrderByTeam(Long seasonId);

    List<TeamMember> findTeamMembersByPlayerNameContainingIgnoreCase(String playerName);

}
