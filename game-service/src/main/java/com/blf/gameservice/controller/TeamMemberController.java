package com.blf.gameservice.controller;

import com.blf.gameservice.search.SearchInput;
import com.blf.gameservice.model.entity.TeamMember;
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

    @GetMapping("/{teamMemberId}")
    public TeamMember getTeamMemberById(@PathVariable Long teamMemberId){
       return teamMemberService.getTeamMemberById(teamMemberId);
    }

    @PostMapping("/search/{seasonId}")
    public List<TeamMember> getAllTeamMembersBySeasonId(@PathVariable Long seasonId) {
        return teamMemberService.getAllTeamMembersBySeasonId(seasonId);
    }

    @PutMapping("/{teamMemberId}")
    public TeamMember updateTeamMember(@PathVariable Long teamMemberId, @RequestBody TeamMember updatedTeamMember) throws IllegalAccessException {
        return teamMemberService.updateTeamMember(teamMemberId, updatedTeamMember);
    }

    @PostMapping("/search")
    public List<TeamMember> getAllByPlayerName(@RequestBody SearchInput input){
        return teamMemberService.getAllByPlayerName(input.getInput());
    }

}
