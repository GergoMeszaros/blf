package com.blf.gameservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class League extends DataModel{


    @JsonProperty("Név")
    private String name;

    @JsonProperty("Szervezet")
    private String organization;

    @ManyToOne
    @JsonProperty("Szezon név")
    private Season season;
}
