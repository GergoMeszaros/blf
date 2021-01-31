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


    private String name;

    private String organization;

    @ManyToOne
    private Season season;
}
