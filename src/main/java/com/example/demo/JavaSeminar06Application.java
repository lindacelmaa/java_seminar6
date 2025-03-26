package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.model.Course;
import com.example.demo.model.Degree;
import com.example.demo.model.Grade;
import com.example.demo.model.Professor;
import com.example.demo.model.Student;
import com.example.demo.repo.ICourseRepo;
import com.example.demo.repo.IGradesRepo;
import com.example.demo.repo.IProfessorRepo;
import com.example.demo.repo.IStudentRepo;


@SpringBootApplication
//@EnableJpaRepositories("lv.venta.repo")
//@EntityScan("lv.venta.model")
@ComponentScan( basePackages = {"com.example.demo", "com.example.demo.controller", "com.example.demo.model", "com.example.demo.repo", "com.example.demo.service", "com.example.demo.service.impl"} )
public class JavaSeminar06Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSeminar06Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testDB(IStudentRepo studRepo, IProfessorRepo profRepo, ICourseRepo courseRepo, IGradesRepo gradeRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
			Student s1 = new Student("Janis", "Berzins");
			Student s2 = new Student("Anna", "Kalnina");
			studRepo.saveAll(Arrays.asList(s1, s2));
			
			Professor p1 = new Professor("Karlis", "Immers", Degree.magistrs);
			Professor p2 = new Professor("Karina", "Skirmante", Degree.magistrs);
			Professor p3 = new Professor("Arturs", "Orbidans", Degree.magistrs);
			Professor p4= new Professor("Karlis", "Laborants", Degree.bakalaurs);
			
			profRepo.saveAll(Arrays.asList(p1, p2, p3, p4));
			
			
			Course c1 = new Course("Programmesana", 4, p2);
			Course c2 = new Course("Tikla Operetajsistemas", 6, p1);
			Course c3 = new Course("Datorsistemu Arhitektura", 6, p3, p4);
			Course c4 = new Course("Datu Strukturas", 3, p1);
			courseRepo.saveAll(Arrays.asList(c1, c2));
			
			p1.addCourse(c2);
			p1.addCourse(c4);
			p2.addCourse(c1);
			p3.addCourse(c3);
			p4.addCourse(c3);
			
			Grade g1 = new Grade(10, s1, c2);
			Grade g2 = new Grade(8, s2, c2);
			Grade g3 = new Grade(9, s1, c1);
			Grade g4 = new Grade(6, s2, c1);
			gradeRepo.saveAll(Arrays.asList(g1, g2, g3, g4));
		
			
			
			}
		
		
	};
	}
	
}
