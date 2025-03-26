package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.Course;
import com.example.demo.model.Grade;
import com.example.demo.model.Student;

public interface ISchoolFilteringService {
	
	public abstract ArrayList<Grade> selectGradesByStudentId(long id) throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByStudentId(long id) throws Exception;
	public abstract ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception;
	
	public abstract float averageGradeInCourse(long id) throws Exception;
	
	public abstract ArrayList<Student> allStudentsWithAtLeastOneBadMark() throws Exception;
	
}
