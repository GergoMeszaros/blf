package com.blf.gameservice.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    int seasonId;
    int homeTeamId;
    int awayTeamId;
    int leagueId;
    int homeTotalScore;
    int awayTotalScore;
    int h1QScore;
    int h1QScoreTaken;
    int h2QScore;
    int h2QScoreTaken;
    int h3QScore;
    int h3QScoreTaken;
    int h4QScore;
    int h4QScoreTaken;
    int hExScore;
    int hExScoreTaken;
    int a1QScore;
    int a1QScoreTaken;
    int a2QScore;
    int a2QScoreTaken;
    int a3QScore;
    int a3QScoreTaken;
    int a4QScore;
    int a4QScoreTaken;
    int aExScore;
    int aExScoreTaken;

    int bestPlayerId;

    String summary;

    @Type(type = "date")
    Date matchDate;
    String address;

}
