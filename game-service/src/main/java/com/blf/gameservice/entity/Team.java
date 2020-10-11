package com.blf.gameservice.entity;

import com.sun.xml.bind.v2.TODO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer seasonId;
    // Integer ageGroupId;
    Integer coachId;
    Integer assistantCoachId;
    Integer leagueId;

    String name;
    String address;

    //Todo (megjegyzés, age_group, blf??)
    //String note;
    //int blf;

}
