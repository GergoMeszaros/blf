package com.blf.gameservice.service;

import com.blf.gameservice.dao.TeamMemberDao;
import com.blf.gameservice.model.entity.Team;
import com.blf.gameservice.model.entity.TeamMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamMemberService {

    private final TeamMemberDao teamMemberDao;
    private final UpdateValidator updateValidator;


    public List<TeamMember> getAllTeamMembers() {
        return teamMemberDao.getAllTeamMembers();
    }

    public List<TeamMember> getAllTeamMembersBySeasonId(Long seasonId) {
        return teamMemberDao.getAllTeamMembersBySeasonId(seasonId);
    }

    public TeamMember updateTeamMember(Long teamMemberId, TeamMember updatedTeamMember) throws IllegalAccessException {
        TeamMember teamMemberToUpdate = teamMemberDao.getTeamMemberById(teamMemberId);

        if (teamMemberToUpdate != null) {
            TeamMember teamMemberToValidate = updateValidator.updater(teamMemberToUpdate, updatedTeamMember);
            teamMemberDao.updateTeamMember(teamMemberToValidate);
        } else {
            log.info("TeamMember not found with the following id: " + teamMemberId);
        }

        return teamMemberToUpdate;
    }

    public TeamMember getTeamMemberById(Long teamMemberId) {
        return teamMemberDao.getTeamMemberById(teamMemberId);
    }

    public List<TeamMember> getAllByPlayerName(String playerName){
        return teamMemberDao.getAllByPlayerName(playerName);
    }

    public void addNewMember(Long teamId, Long playerId) {
        Team team = Team.builder()
                .id(teamId)
                .build();

        Player player = Player.builder()
                .id(playerId)
                .build();
        TeamMember teamMember = TeamMember.builder()
                .team(team)
                .player(player)
                .build();
        teamMemberDao.addNewMember(teamMember);
    }
}
