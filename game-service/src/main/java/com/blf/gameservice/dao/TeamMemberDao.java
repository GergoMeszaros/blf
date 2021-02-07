package com.blf.gameservice.dao;

import com.blf.gameservice.model.entity.Team;
import com.blf.gameservice.model.entity.TeamMember;

import java.util.List;

public interface TeamMemberDao {

    List<TeamMember> getAllTeamMembers();

    List<TeamMember> getAllTeamMembersBySeasonId(Long seasonId);

    List<TeamMember> getAllByPlayerName(String playerName);

    TeamMember getTeamMemberById(Long teamMemberId);

    void updateTeamMember(TeamMember updatedTeamMember);

    void addNewMember(TeamMember teamMember);

    void deleteByPlayerIdAndTeamId(Long playerId, Long teamId);

}
