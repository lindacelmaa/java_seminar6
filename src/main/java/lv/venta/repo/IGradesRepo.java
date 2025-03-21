package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.service.Grade;

public interface IGradesRepo extends CrudRepository<Grade, Long>{

}
