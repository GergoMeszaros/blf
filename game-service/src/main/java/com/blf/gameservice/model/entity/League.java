package com.blf.gameservice.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class League extends BaseEntity {


    @JsonProperty("Név")
    private String name;

    @JsonProperty("Szervezet")
    private String organization;

    @ManyToOne
    private Season season;
}
