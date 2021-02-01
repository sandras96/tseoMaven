package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

	@Query(value = "SELECT p.* FROM professor p JOIN course_professor cp ON p.professor_id = cp.professor_id WHERE cp.course_id =?",nativeQuery = true)
	List<Professor> getAllByCourseId(Integer id);
	
	Professor findByUserId(Integer id);
}
