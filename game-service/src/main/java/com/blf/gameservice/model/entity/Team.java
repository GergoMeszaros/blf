package com.blf.gameservice.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team extends BaseEntity {

    @JsonIgnore
    private Integer blf;

    @Transient
    private String isBlfTeam;

    private String name;
    private String address;

    @ManyToOne
    private Season season;

    @ManyToOne
    private League league;


    /*@OneToMany
    @JoinTable(
            name = "team_member",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<TeamMember> teamMember;*/


    @PostLoad
    private void setIsBlf() {
        if (blf == 1) {
            isBlfTeam = "Blf";
        } else {
            isBlfTeam = "";
        }
    }
}
