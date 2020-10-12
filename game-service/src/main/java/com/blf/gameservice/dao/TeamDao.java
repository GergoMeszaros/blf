package com.blf.gameservice.dao;
import com.blf.gameservice.entity.Team;

import java.util.List;

public interface TeamDao {

    List<Team> getAllTeam();

    Team addNewTeam(Team team);
}
