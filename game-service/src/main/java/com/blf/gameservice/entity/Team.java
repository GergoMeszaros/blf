package com.blf.gameservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToMany
    @JsonIgnore
    private Set<Event> events;

    @ManyToOne
    private Season season;

    @OneToMany(mappedBy = "team")
    @JsonBackReference
    private Set<TeamMember> teamMemberSet;
}
