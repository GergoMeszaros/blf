package com.blf.gameservice.daodb;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.dao.TeamDao;
import com.blf.gameservice.entity.Team;
import com.blf.gameservice.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamDaoDB implements TeamDao {


    private final TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    @Override
    public List<Team> getAllTeamsBySeasonId(Long seasonId) {
        return teamRepository.findAllBySeasonId(seasonId);
    }

    @Override
    public List<Team> getTeamsByTeamName(SearchInput team) {
        return teamRepository.findAllByNameContainingIgnoreCase(team.getInput());
    }

    @Override
    public List<Team> getAllBlfTeams() {
        return teamRepository.getAllBlfTeams();
    }

    @Override
    public Team getTeamById(Long teamId) {
        return teamRepository.findById(teamId).orElse(null);
    }

    @Override
    public Team addNewTeam(Team team) {
        return teamRepository.saveAndFlush(team);
    }

    @Override
    public Team updateTeam(Long teamId, Team updatedTeam) {
        Team teamToUpdate = teamRepository.findById(teamId).orElse(null);

        if (teamToUpdate != null) {
            teamToUpdate.setName(updatedTeam.getName());
            teamToUpdate.setAddress(updatedTeam.getAddress());

            teamRepository.saveAndFlush(teamToUpdate);
        } else {
            log.info("Team not found with the following id: " + teamId);
        }

        return teamToUpdate;
    }

    @Override
    public Team deleteTeam(Long teamId) {
        Team teamToDelete = teamRepository.findById(teamId).orElse(null);

        if (teamToDelete != null) {
            teamRepository.deleteById(teamId);
            log.info("Team deleted: " + teamToDelete);
        }
        return teamToDelete;
    }
}
