package com.example.familyexpenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@EnableScheduling
public class FamilyexpensesApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(FamilyexpensesApplication.class, args);
    }

}
