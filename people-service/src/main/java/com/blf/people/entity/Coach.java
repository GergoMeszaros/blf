package com.blf.people.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coach {

    @Id
    @GeneratedValue
    Long id;

    String name;
    String email;
    String phoneNumber;
    String title;
    String photoRoot;
}
