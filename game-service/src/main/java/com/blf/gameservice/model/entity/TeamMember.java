package com.blf.gameservice.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamMember extends BaseEntity {


    @ManyToOne
    private Team team;

    @OneToOne
    private Player player;

    @Transient
    private String seasonName;

    @Transient
    private String isBlfTeam;

    /**
     This method executes only if the required field is not "null".
     Calls the other methods which gather information from the "Team" object.
     As well as sets the value of the "Transient" fields.
     * */
    @PostLoad
    private void postLoad() {
        setSeason();
        setIsBlfTeam();
    }

    private void setIsBlfTeam(){
        if(team != null) {
            this.isBlfTeam = team.getIsBlfTeam();
        }
    }

    private void setSeason() {
        if (team != null) {
            this.seasonName = team.getSeason().getName();
        }
    }
}
