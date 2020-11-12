package com.blf.gameservice.controller;

import com.blf.gameservice.dao.TeamMemberDao;
import com.blf.gameservice.daodb.TeamMemberDaoDB;
import com.blf.gameservice.entity.TeamMember;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teammember")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class TeamMemberController {

    TeamMemberDao teamMemberDao;


    @GetMapping("")
    public List<TeamMember> getAllTeamMembers(){
        return teamMemberDao.getAllTeamMembers();
    }
}
