package com.example.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.Grade;
import com.example.demo.model.Student;
import com.example.demo.repo.ICourseRepo;
import com.example.demo.repo.IGradesRepo;
import com.example.demo.repo.IProfessorRepo;
import com.example.demo.repo.IStudentRepo;
import com.example.demo.service.ISchoolFilteringService;

@Service
public class FiltServiceImpl implements ISchoolFilteringService {
	
	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradesRepo gradesRepo;
	
	@Autowired
	private ICourseRepo	courseRepo;
	
	@Autowired
	private IProfessorRepo profRepo;
	
	@Override
	public ArrayList<Grade> selectGradesByStudentId(long id) throws Exception{
		if(id <= 0) {
			throw new Exception("Id should be positive");
		}
		if(!studRepo.existsById(id)) {
			throw new Exception("Student does not exist");
		}
		ArrayList<Grade> result = gradesRepo.findByStudentPeid(id);
		
		if(result.isEmpty()) {
			throw new Exception("There is no grade linked to student");
		}
		return result;
		
		
	}
	
	@Override
	public ArrayList<Course> selectCoursesByStudentId(long id) throws Exception{
		if(id <= 0) {
			throw new Exception("Id should be positive");
		}
		if(!studRepo.existsById(id)) {
			throw new Exception("Student does not exist");
		}
		ArrayList<Course> result = courseRepo.findByGradesStudentPeid(id);
		
		if(result.isEmpty()) {
			throw new Exception("There is no course linked to student");
		}
		return result;
		
		
	}
	@Override
	public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception{
		if(id <= 0) {
			throw new Exception("Id should be positive");
		}
		if(!profRepo.existsById(id)) {
			throw new Exception("Student does not exist");
		}
		
		ArrayList<Course> result = courseRepo.findByProfessorPeid(id);
		
		if(result.isEmpty()) {
			throw new Exception("There is no course linked to professor");
		}
		return result;
		
		
	}
	@Override
	public float averageGradeInCourse(long id) throws Exception{
		if(id <= 0) {
			throw new Exception("Id should be positive");
		}
		if(!courseRepo.existsById(id)) {
			throw new Exception("Course does not exist");
		}
		
		if(!gradesRepo.existsByCourseCid(id)) {
			throw new Exception("The course does not have any grades!");
		}
		
		
		float result = gradesRepo.calculateAVGGradeByCourseId(id);
		return result;
	}
	
	//visus studentus kuriem ir vismaz viena nesekmiga atzime
	@Override
	public ArrayList<Student> allStudentsWithAtLeastOneBadMark() throws Exception{
		
		ArrayList<Student> result = studRepo.findByGradesValueLessThan(4);
		
		if(result.isEmpty()) {
			throw new Exception("There is no course linked to professor");
		}
		return result;
	}
}
