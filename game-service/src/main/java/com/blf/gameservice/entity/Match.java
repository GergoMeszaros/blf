package com.blf.gameservice.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "season_id", updatable = false, insertable = false)
    Integer seasonId;

    @Column(name = "league_id", updatable = false, insertable = false)
    Integer leagueId;


   // private Season season;

   // private League league;



    Integer homeTeamId;
    Integer awayTeamId;

    Integer homeTotalScore;
    Integer awayTotalScore;
    Integer h1QScore;
    Integer h1QScoreTaken;
    Integer h2QScore;
    Integer h2QScoreTaken;
    Integer h3QScore;
    Integer h3QScoreTaken;
    Integer h4QScore;
    Integer h4QScoreTaken;
    Integer hExScore;
    Integer hExScoreTaken;
    Integer a1QScore;
    Integer a1QScoreTaken;
    Integer a2QScore;
    Integer a2QScoreTaken;
    Integer a3QScore;
    Integer a3QScoreTaken;
    Integer a4QScore;
    Integer a4QScoreTaken;
    Integer aExScore;
    Integer aExScoreTaken;

    Integer bestPlayerId;

    String summary;

    @Type(type = "date")
    Date matchDate;
    String address;
}
