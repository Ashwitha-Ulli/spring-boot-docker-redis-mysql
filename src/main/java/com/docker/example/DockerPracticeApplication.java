package com.docker.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DockerPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerPracticeApplication.class, args);
	}

}
