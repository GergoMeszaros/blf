package com.blf.gameservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private Long id;
    private String name;
    private String pictureRoot;
    private String pictureRootSecond;
    private String school;
    private String position;
    private Date birthdate;
    private String birthplace;
    private String telephone;
    private String playerSummary;
    private Integer isActive;
    private Integer startDate;
    private Integer age;
    private Integer height;

}
