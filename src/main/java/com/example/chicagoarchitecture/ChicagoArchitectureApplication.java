package com.example.chicagoarchitecture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChicagoArchitectureApplication implements CommandLineRunner {

    // Trying to find out username and password for environment variables
    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public static void main(String[] args) {
        SpringApplication.run(ChicagoArchitectureApplication.class, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("MySQL Username: " + username);
        System.out.println("MySQL Password: " + password);
    }

}
