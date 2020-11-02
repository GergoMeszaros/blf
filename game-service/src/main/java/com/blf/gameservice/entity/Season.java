package com.blf.gameservice.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@JsonIgnoreProperties(value = {"leagues"})
public class Season {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String date;

    @OneToMany( mappedBy = "season")
    @JsonIgnore
    //@JsonBackReference
    private Set<League> leagues;
}
