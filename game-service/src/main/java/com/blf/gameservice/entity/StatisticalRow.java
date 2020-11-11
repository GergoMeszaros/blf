package com.blf.gameservice.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticalRow {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Integer playedTime;

    @Column(name = "3pt_attempt")
    private Integer pt3Attempt;

    @Column(name = "3pt_made")
    private Integer pt3Made;

    private Integer midRangeAttempt;
    private Integer midRangeMade;
    private Integer closeShotAttempt;
    private Integer closeShotMade;
    private Integer shotPercentage;
    private Integer freeThrowAttempt;
    private Integer freeThrowPercentage;
    private Integer defensiveRebound;
    private Integer offensiveRebound;
    private Integer totalRebound;
    private Integer steal;
    private Integer turnover;
    private Integer fouledAgainst;
    private Integer committedFoul;
    private Integer assist;
    private Integer technicalMistake;
    private Integer block;
    private Integer ibm;
    private Integer totalPts;


}
