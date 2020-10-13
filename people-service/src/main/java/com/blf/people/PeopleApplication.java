package com.blf.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PeopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleApplication.class, args);
	}

}
