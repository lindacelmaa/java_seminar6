package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface IStudentRepo extends CrudRepository<Student, Long>{

	ArrayList<Student> findByGradesValueLessThan(int i);

}
