package com.blf.gameservice.model.dto;


import com.blf.gameservice.model.entity.League;
import com.blf.gameservice.model.entity.Season;
import com.blf.gameservice.model.entity.TeamMember;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO extends BaseDTO{



    private String isBlfTeam;

    private String name;
    private String address;

    private Season season;

    private League league;

   // private Set<TeamMember> teamMember;
}
