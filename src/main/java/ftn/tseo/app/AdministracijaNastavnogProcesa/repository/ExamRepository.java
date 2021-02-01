package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>{
	
	List<Exam> findAllByCourseId(Integer id);
	List<Exam> findAllByExamPeriodId(Integer id);
	
	@Query(value = "SELECT e.* FROM exam e JOIN exam_taking et ON e.exam_id = et.exam_id WHERE student_id=?;",nativeQuery = true)
	List<Exam> getAllByStudentId(Integer id);
}
