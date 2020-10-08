package com.blf.people.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String pictureRoot;
    String pictureRootSecond;
    String school;
    String position;
    @Type(type = "date")
    Date birthdate;
    String birthplace;
    String telephone;
    String playerSummary;
    Integer isActive;
    Integer startDate;
    Integer age;
    Integer height;
}
