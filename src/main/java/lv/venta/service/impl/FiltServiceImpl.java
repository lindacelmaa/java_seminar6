package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradesRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.ISchoolFilteringService;

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
		ArrayList<Grade> result = gradesRepo.findByStudentsStId(id);
		
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
		ArrayList<Course> result = courseRepo.findByGradesStudentStId(id);
		
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
		
		//ArrayList<Course> result = courseRepo.find
		
		
		return null;
	}
	@Override
	public float averageGradeInCourse(long id) throws Exception{
		return 0;
	}
}
