package com.blf.gameservice.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String organization;
    //Integer seasonId;
    Integer ageGroupId;

   @ManyToOne
   @JsonManagedReference
   @ToString.Exclude
   @EqualsAndHashCode.Exclude
   //@JoinColumn(name = "seasonId", insertable = false, updatable = false)
   private Season season;
}
