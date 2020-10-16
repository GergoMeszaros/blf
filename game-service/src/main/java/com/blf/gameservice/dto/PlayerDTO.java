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
    //@Type(type = "date")
    Date birthdate;
    String name;
    String pictureRoot;
    String pictureRootSecond;
    String school;
    String position;
    String birthplace;
    String telephone;
    String playerSummary;
    Integer isActive;
    Integer startDate;
    Integer age;
    Integer height;
}
