package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Professor;

public interface IProfessorRepo extends CrudRepository<Professor, Long>{

}
