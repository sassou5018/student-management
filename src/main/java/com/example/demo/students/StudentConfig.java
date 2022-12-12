package com.example.demo.students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student st1 = new Student(
                    "Yassine",
                    "Yassine@gmail.com",
                    LocalDate.of(2001, Month.MAY, 24)
            );
            Student st2 = new Student(
                    "Alex",
                    "Alex@gmail.com",
                    LocalDate.of(2001, Month.MAY, 26)
            );
            repository.saveAll(
                    List.of(st1, st2)
            );
        };
    }
}
