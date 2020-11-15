package com.blf.gameservice.entity;

import lombok.*;
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

    @OneToOne
    private Player player;

    @Transient
    private String seasonName;

    @PostLoad
    private void postLoad() {
        setSeason();
    }

    public void setSeason() {
        if (team != null) {
            this.seasonName = team.getSeason().getName();
        }
    }
}
