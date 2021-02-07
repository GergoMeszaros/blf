package com.blf.gameservice.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Player extends BaseEntity {


    private String name;

    private String pictureRoot;

    private String pictureRootSecond;

    private String school;

    private String position;

    //@Type(type = "date")
    @Temporal(value = TemporalType.DATE)
    private Date birthdate;

    private String birthplace;

    private String telephone;

    private String playerSummary;

    private Integer isActive;

    private Integer startDate;

    @Formula("FLOOR(DATEDIFF(now(), birthdate) / 365)")
    private Integer age;

    private Integer height;

    @ManyToOne
    private Season season;

}
