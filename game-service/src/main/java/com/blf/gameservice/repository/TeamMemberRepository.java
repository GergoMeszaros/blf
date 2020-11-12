package com.blf.gameservice.repository;
import com.blf.gameservice.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

}
