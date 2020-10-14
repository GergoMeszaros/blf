package com.blf.gameservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "season_id", updatable = false, insertable = false)
    Integer seasonId;

    @Column(name = "league_id", updatable = false, insertable = false)
    Integer leagueId;

    //@Type(type = "date")
    Date eventDate;

    Integer homeTeamId;
    Integer awayTeamId;
    Integer homeTotalScore;
    Integer awayTotalScore;
    Integer h1qScore;
    Integer h1qTaken;
    Integer h2qScore;
    Integer h2qTaken;
    Integer h3qScore;
    Integer h3qTaken;
    Integer h4qScore;
    Integer h4qTaken;
    Integer hExScore;
    Integer hExTaken;
    Integer a1qScore;
    Integer a1qTaken;
    Integer a2qScore;
    Integer a2qTaken;
    Integer a3qScore;
    Integer a3qTaken;
    Integer a4qScore;
    Integer a4qTaken;
    Integer aExScore;
    Integer aExTaken;
    Integer bestPlayerId;
    String summary;
    String address;

/*
    @Formula("h1q_score * h2q_score")
    Integer teszt;
*/

    @ManyToMany(mappedBy = "teams")
    private Set<Team> teamSet;


    @ManyToOne
    @JsonManagedReference
    private League league;
}
