package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course.Semester;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
//	List<Course> findByNameContaining(String name);
	
	@Query(value = "SELECT c.* FROM course c JOIN course_professor cp ON c.course_id = cp.course_id JOIN professor p ON cp.professor_id = p.professor_id WHERE p.professor_id = ?;",nativeQuery = true)
	List<Course> getAllByProfessorId(Integer id);
	
	
	List<Course> findByNameContaining(String title);
	
	List<Course> findByEspb(Float espb);
	@Query(value = "Select * from course where semester like ?;",nativeQuery = true)
	List<Course> findBySemester(String semester);
	

}
