package com.blf.gameservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamMember {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Team team;

    private Long playerId;

}
