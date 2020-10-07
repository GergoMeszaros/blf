package com.blf.people.entity;
import com.sun.istack.NotNull;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue
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
