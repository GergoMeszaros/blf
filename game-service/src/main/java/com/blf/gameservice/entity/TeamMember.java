package com.blf.gameservice.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamMember {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "player_id", insertable = false, updatable = false)
    Integer playerId;

    @Column(name = "team_id", insertable = false, updatable = false)
    Integer teamId;

    @ManyToOne
    @JsonManagedReference
    private Team team;

}
