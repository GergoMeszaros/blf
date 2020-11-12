package com.blf.gameservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer blf;

    private String name;
    private String address;

 /*   @OneToMany(mappedBy = "homeTeam")
    @JsonBackReference
    private Set<Event> events;

    @OneToMany(mappedBy = "awayTeam")
    @JsonBackReference
    private Set<Event> events2;
*/

    @ManyToOne
    private Season season;

    @OneToMany(mappedBy = "team")
    @JsonBackReference
    @Transient
    private Set<TeamMember> teamMemberSet;
}
