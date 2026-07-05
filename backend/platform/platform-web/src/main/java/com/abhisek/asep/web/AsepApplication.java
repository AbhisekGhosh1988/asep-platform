package com.abhisek.asep.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.abhisek.asep")
@EnableJpaRepositories(basePackages = {"com.abhisek.asep.identity.infrastructure.persistence.repository", "com.abhisek.asep.project.infrastructure.persistence.repository", "com.abhisek.asep.requirements.infrastructure.persistence.repository"})
@EntityScan(basePackages = {"com.abhisek.asep.identity.infrastructure.persistence.entity", "com.abhisek.asep.project.infrastructure.persistence.entity", "com.abhisek.asep.requirements.infrastructure.persistence.entity"})
public class AsepApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsepApplication.class, args);
    }

}