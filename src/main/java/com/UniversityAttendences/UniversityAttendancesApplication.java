package com.UniversityAttendences;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class UniversityAttendancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityAttendancesApplication.class, args);
		log.info("The application is running properly!");
	}

}
