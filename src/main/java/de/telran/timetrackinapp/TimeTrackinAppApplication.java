package de.telran.timetrackinapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TimeTrackinAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeTrackinAppApplication.class, args);
    }
}
