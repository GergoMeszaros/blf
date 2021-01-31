package com.blf.gameservice.model.dto;


import com.blf.gameservice.model.entity.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LeagueDTO extends BaseDTO {

    private String name;

    private String organization;

    private Season season;


}

