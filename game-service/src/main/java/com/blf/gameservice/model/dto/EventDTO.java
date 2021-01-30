package com.blf.gameservice.model.dto;

import com.blf.gameservice.model.entity.League;
import com.blf.gameservice.model.entity.Season;
import com.blf.gameservice.model.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO extends BaseDTO{

    private Date eventDate;

    private Integer homeTotalScore;
    private Integer awayTotalScore;
    private Integer h1qScore;
    private Integer h1qTaken;
    private Integer h2qScore;
    private Integer h2qTaken;
    private Integer h3qScore;
    private Integer h3qTaken;
    private Integer h4qScore;
    private Integer h4qTaken;
    private Integer hExScore;
    private Integer hExTaken;
    private Integer a1qScore;
    private Integer a1qTaken;
    private Integer a2qScore;
    private Integer a2qTaken;
    private Integer a3qScore;
    private Integer a3qTaken;
    private Integer a4qScore;
    private Integer a4qTaken;
    private Integer aExScore;
    private Integer aExTaken;

    private String address;

    @Column(columnDefinition = "text")
    private String summary;

    private Season season;

    private League league;

    private Team homeTeam;

    private Team awayTeam;

}
