package com.appl.studentsbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.appl.controllers","com.appl.entities",
		"com.appl.repos","com.appl.services","com.appl.studentsbooks"})
@EnableJpaRepositories({"com.appl.controllers","com.appl.entities",
		"com.appl.repos","com.appl.services","com.appl.studentsbooks"})
@EntityScan("com.appl.entities")
public class StudentsbooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsbooksApplication.class, args);
	}

}
