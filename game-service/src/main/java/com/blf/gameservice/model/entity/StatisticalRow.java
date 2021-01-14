package com.blf.gameservice.model.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity(name = "statistical_row")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticalRow extends BaseEntity {


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

    @ManyToOne
    private Player player;
}
