package com.blf.gameservice.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String pictureRoot;
    private String pictureRootSecond;
    private String school;
    private String position;

    @Type(type = "date")
    private Date birthdate;

    private String birthplace;
    private String telephone;
    private String playerSummary;
    private Integer isActive;
    private Integer startDate;
    private Integer age;
    private Integer height;

    @ManyToOne
    private Season season;

}
