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
public class Season {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

   /* @OneToMany( mappedBy = "season")
    @JsonBackReference
    private Set<League> leagues;
*/
    /*@OneToMany(mappedBy = "season")
    @JsonBackReference
    private Set<Event> events;
*/
    /*@OneToMany(mappedBy = "season")
    @JsonBackReference
    private Set<Team> teams;*/

}
