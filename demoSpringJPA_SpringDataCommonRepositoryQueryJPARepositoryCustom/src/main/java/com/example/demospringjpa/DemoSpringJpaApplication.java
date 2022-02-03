package com.example.demospringjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = MyRepositoryImpl.class)
public class DemoSpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringJpaApplication.class, args);

    }

}