package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.model.Student;

@Repository
public interface IStudentRepo extends CrudRepository<Student, Long>{

	ArrayList<Student> findByGradesValueLessThan(int i);

}
