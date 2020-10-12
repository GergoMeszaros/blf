package com.blf.gameservice.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String organization;
    Integer ageGroupId;

    @Column(name = "season_id", insertable = false, updatable = false)
    Integer seasonId;

    @ManyToOne
    @JsonManagedReference
    private Season season;

    @OneToMany(mappedBy = "league")
    @JsonBackReference
    private Set<Event> eventSet;
}
