package org.application.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.application.repository")
public class PatientManagementSystem {

    public static void main(String[] args) {
        SpringApplication.run(org.application.app.PatientManagementSystem.class, args);
    }
}

