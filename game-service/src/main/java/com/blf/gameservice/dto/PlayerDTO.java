package com.blf.gameservice.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    Long id;
    String name;
    String pictureRoot;
    String pictureRootSecond;
    String school;
    String position;
    Date birthdate;
    String birthplace;
    String telephone;
    String playerSummary;
    Integer isActive;
    Integer startDate;
    Integer age;
    Integer height;
}
