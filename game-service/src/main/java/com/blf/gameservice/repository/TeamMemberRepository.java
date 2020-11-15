package com.blf.gameservice.repository;

import com.blf.gameservice.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

}
