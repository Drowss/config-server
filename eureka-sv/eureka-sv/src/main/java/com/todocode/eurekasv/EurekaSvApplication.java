package com.todocode.eurekasv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@EnableEurekaServer
public class EurekaSvApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaSvApplication.class, args);
	}

}
