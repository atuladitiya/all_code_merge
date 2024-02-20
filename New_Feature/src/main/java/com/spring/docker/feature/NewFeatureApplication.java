package com.spring.docker.feature;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NewFeatureApplication {
	public static void main(String[] args) {
		SpringApplication.run(NewFeatureApplication.class, args);
	}

}
