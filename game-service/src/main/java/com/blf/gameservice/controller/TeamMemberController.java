package com.blf.gameservice.controller;

import com.blf.gameservice.entity.TeamMember;
import com.blf.gameservice.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teammember")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class TeamMemberController {

    private final TeamMemberService teamMemberService;


    @GetMapping("")
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberService.getAllTeamMembers();
    }

    @GetMapping("/season/{seasonId}")
    public List<TeamMember> getAllTeamMembersBySeasonId(@PathVariable Long seasonId) {
        return teamMemberService.getAllTeamMembersBySeasonId(seasonId);
    }
}
