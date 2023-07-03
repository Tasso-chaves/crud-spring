package com.dev.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dev.crudspring.model.Course;
import com.dev.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner iniDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular");
			c.setCategory("Front-end");

			Course c2 = new Course();
			c2.setName("Java");
			c2.setCategory("Back-end");

			courseRepository.save(c);
			courseRepository.save(c2);
		};
	}
}
