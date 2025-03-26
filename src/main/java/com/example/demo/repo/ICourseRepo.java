package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Long>{

	public abstract ArrayList<Course> findByGradesStudentStid(long id);

	public abstract ArrayList<Course> findByProfessorsPid(long id);

}
