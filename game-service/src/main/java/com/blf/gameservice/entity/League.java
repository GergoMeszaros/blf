package com.blf.gameservice.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
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
    //@JsonManagedReference
    @JsonIgnore
    private Season season;

    @OneToMany(mappedBy = "league")
    @JsonIgnore
    private Set<Event> eventSet;
}
