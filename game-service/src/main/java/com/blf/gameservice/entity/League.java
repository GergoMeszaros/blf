package com.blf.gameservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Név")
    private String name;

    @JsonProperty("Szervezet")
    private String organization;

    @ManyToOne
    @JsonProperty("Szezon név")
    private Season season;

}
