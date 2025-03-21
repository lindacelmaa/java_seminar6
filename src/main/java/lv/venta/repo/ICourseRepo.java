package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.service.Course;

public interface ICourseRepo extends CrudRepository<Course, Long>{

}
