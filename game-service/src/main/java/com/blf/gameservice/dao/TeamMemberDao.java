package com.blf.gameservice.dao;

import com.blf.gameservice.entity.TeamMember;

import java.util.List;

public interface TeamMemberDao {

    List<TeamMember> getAllTeamMembers();

    List<TeamMember> getAllTeamMembersBySeasonId(Long seasonId);

    TeamMember getTeamMemberById(Long teamMemberId);

    void updateTeamMember(TeamMember updatedTeamMember);
}
