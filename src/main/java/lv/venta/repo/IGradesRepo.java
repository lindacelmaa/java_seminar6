package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradesRepo extends CrudRepository<Grade, Long>{
	
	public abstract ArrayList<Grade> findByStudentsStId(long id);

	@Query(nativeQuery = true, value = "SELECT avg(value) FROM grade_table WHERE cid = ?1;")
	public abstract float calculateAVGGradeByCourseId(long id);

	public abstract boolean existsByCourseCId(long id);

}
