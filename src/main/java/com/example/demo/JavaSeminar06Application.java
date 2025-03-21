package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradesRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.Course;
import lv.venta.service.Degree;
import lv.venta.service.Grade;
import lv.venta.service.Professor;
import lv.venta.service.Student;

@SpringBootApplication
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
			Student s2 = new Student("Anna", "Kalnina-Kalna");
			studRepo.saveAll(Arrays.asList(s1, s2));
			
			Professor p1 = new Professor("Karlis", "Immers", Degree.magistrs);
			Professor p2 = new Professor("Karina", "Skirmante", Degree.magistrs);
			profRepo.saveAll(Arrays.asList(p1, p2));
			
			
			Course c1 = new Course("Programmesana", 4, p2);
			Course c2 = new Course("Tikla operetajsistemas", 6, p1);
			courseRepo.saveAll(Arrays.asList(c1, c2));
			
			Grade g1 = new Grade(10, s1, c2);
			Grade g2 = new Grade(8, s2, c2);
			Grade g3 = new Grade(9, s1, c1);
			Grade g4 = new Grade(6, s2, c1);
			gradeRepo.saveAll(Arrays.asList(g1, g2, g3, g4));
		
			
			
			};
		
		
	};
	}
	
}
