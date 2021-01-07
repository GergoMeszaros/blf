package com.blf.gameservice.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Season extends DataModel{

    private String name;
}
