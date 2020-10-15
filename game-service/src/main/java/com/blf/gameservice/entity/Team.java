package com.blf.gameservice.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "season_id", updatable = false, insertable = false)
    Integer seasonId;

    Integer ageGroupId;
    Integer coachId;
    Integer assistantCoachId;
    Integer blf;

    @Column(name = "league_id", updatable = false, insertable = false)
    Integer leagueId;

    String name;
    String address;

    //Todo (megjegyzés, age_group, blf??)
    //String note;
    //int blf;


    @OneToMany(mappedBy = "team")
    @JsonBackReference
    private Set<TeamMember> teamMemberSet;
}
