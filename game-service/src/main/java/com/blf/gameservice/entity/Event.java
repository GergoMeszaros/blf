package com.blf.gameservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "date")
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
    @Column(columnDefinition = "text")
    private String summary;
    private String address;

    @ManyToOne
    private Season season;

    @ManyToOne
    private League league;

    @ManyToMany(mappedBy = "events")
    @JsonBackReference
    private Set<Team> teams;


}
