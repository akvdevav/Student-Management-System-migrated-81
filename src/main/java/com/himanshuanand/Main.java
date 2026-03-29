package com.himanshuanand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by himanshuanand on 5/4/17.
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Main.class);
        // Activate the development profile to use the in‑memory H2 database,
        // avoiding connection attempts to a non‑existent PostgreSQL database.
        application.setAdditionalProfiles("dev");
        application.run(args);
    }
}