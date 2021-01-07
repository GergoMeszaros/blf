package com.blf.gameservice.entity;

import lombok.*;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamMember extends DataModel{


    @ManyToOne
    private Team team;

    @OneToOne
    private Player player;

    @Transient
    private String seasonName;

    @Transient
    private String isBlfTeam;


    @PostLoad
    private void postLoad() {
        setSeason();
        setIsBlfTeam();
    }

    public void setIsBlfTeam(){
        if(team != null) {
            this.isBlfTeam = team.getBlf() == 1 ? "Blf" : "";
        }
    }

    public void setSeason() {
        if (team != null) {
            this.seasonName = team.getSeason().getName();
        }
    }
}
