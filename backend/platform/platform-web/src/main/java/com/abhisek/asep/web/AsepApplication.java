package com.abhisek.asep.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.abhisek.asep")
public class AsepApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsepApplication.class, args);
    }

}