package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>{
	
	List<Exam> findAllByCourseId(Integer id);
	List<Exam> findAllByExamPeriodId(Integer id);
	
	@Query(value = "SELECT e.* FROM exam e JOIN exam_taking et ON e.exam_id = et.exam_id WHERE student_id=?;",nativeQuery = true)
	List<Exam> getAllByStudentId(Integer id);
	
	List<Exam> findByExamPeriodNameContaining(String name);
	List<Exam> findByExamPeriodNameContainingAndCourseId(String name, Integer id);
	List<Exam> findByCourseNameContaining(String name);
	List<Exam> findByCourseNameContainingAndExamPeriodId(String name, Integer id);
	
	@Query(value = "SELECT * FROM exam e JOIN sign_exams se ON se.exam_id = e.exam_id WHERE se.student_id=?;",nativeQuery = true)
	Set<Exam> getAllRegisteredExams(Integer id);
	
	@Query(value = " SELECT e.* from exam e LEFT JOIN sign_exams se ON e.exam_id = se.exam_id WHERE se.exam_id IS NULL;",nativeQuery = true)
	List<Exam> getAllUnregisteredExams();
}
