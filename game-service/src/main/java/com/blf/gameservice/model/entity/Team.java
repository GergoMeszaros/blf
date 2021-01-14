package com.blf.gameservice.model.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team extends BaseEntity {


    private Integer blf;

    private String name;
    private String address;

    @ManyToOne
    private Season season;
}
