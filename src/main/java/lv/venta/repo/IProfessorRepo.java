package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.service.Professor;

public interface IProfessorRepo extends CrudRepository<Professor, Long>{

}
