package com.blf.gameservice.service;

import com.blf.gameservice.dao.TeamMemberDao;
import com.blf.gameservice.entity.TeamMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamMemberService {

    private final TeamMemberDao teamMemberDao;


    public List<TeamMember> getAllTeamMembers() {
        return teamMemberDao.getAllTeamMembers();
    }

    public List<TeamMember> getAllTeamMembersBySeasonId(Long seasonId) {
        return teamMemberDao.getAllTeamMembersBySeasonId(seasonId);
    }
}
