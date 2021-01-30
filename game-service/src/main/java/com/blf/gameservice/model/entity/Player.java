package com.blf.gameservice.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player extends BaseEntity {


    //@JsonProperty("Név")
    private String name;

    @JsonProperty("Fénykép")
    private String pictureRoot;

    @JsonProperty("Fénykép 2")
    private String pictureRootSecond;

    @JsonProperty("Iskola")
    private String school;

    @JsonProperty("Pozíció")
    private String position;

    @Type(type = "date")
    @JsonProperty("Születési dátum")
    private Date birthdate;

    @JsonProperty("Születési hely")
    private String birthplace;

    @JsonProperty("Telefonszám")
    private String telephone;

    @JsonProperty("Összesítés")
    private String playerSummary;

    @JsonProperty("Aktív")
    private Integer isActive;

    @JsonProperty("Kezdő dátum")
    private Integer startDate;

    @JsonProperty("Kor")
    private Integer age;

    @JsonProperty("Magasság")
    private Integer height;

    @ManyToOne
    private Season season;
}
