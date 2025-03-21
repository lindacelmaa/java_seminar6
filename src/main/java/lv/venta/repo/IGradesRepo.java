package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradesRepo extends CrudRepository<Grade, Long>{
	
	public abstract ArrayList<Grade> findByStudentsStId(long id);

}
