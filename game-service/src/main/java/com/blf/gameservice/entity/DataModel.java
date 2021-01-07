package com.blf.gameservice.entity;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class DataModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
}
