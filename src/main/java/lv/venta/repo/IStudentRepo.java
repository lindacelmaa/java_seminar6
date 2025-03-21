package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.service.Student;

public interface IStudentRepo extends CrudRepository<Student, Long>{

}
