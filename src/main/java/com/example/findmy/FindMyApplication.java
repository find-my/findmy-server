package com.example.findmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class FindMyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindMyApplication.class, args);
    }

}
