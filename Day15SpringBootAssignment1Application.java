package com.synergisticit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.synergisticit"})
@PropertySource("classpath:a.properties")
public class Day15SpringBootAssignment1Application {

    public static void main(String[] args) {
        SpringApplication.run(Day15SpringBootAssignment1Application.class, args);
    }
}
