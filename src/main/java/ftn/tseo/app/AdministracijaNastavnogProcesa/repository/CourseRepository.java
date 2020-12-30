package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	List<Course> findByNameContaining(String name);
	
	@Query(value = "SELECT course_id FROM course_professor WHERE professor_id = 1",nativeQuery = true)
	List<Course> getAllByProfessorId(Integer id);
	
	
	
	/*
	 * @Query(value =
	 * "SELECT c.* FROM Course c JOIN FETCH c.professors WHERE c.course_id = 1",
	 * nativeQuery = true) List<Course> getAllByProfessorId(Integer id);
	 */

}
