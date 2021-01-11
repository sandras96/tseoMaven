package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CourseAttendance;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;

public interface CourseAttendanceRepository extends JpaRepository<CourseAttendance, Integer>{
	
	List<CourseAttendance> findCourseAttendanceByStudentId(Integer id);
	List<CourseAttendance> findCourseAttendanceByCourseId(Integer id);

	@Query(value = "SELECT DISTINCT s.* FROM student s JOIN course_attendance ca ON s.student_id = ca.student_id WHERE s.student_id NOT IN (SELECT ca.student_id FROM course_attendance ca WHERE ca.course_id = ?);",nativeQuery = true)
	List<Student> getStudentsNotIn(Integer id);
}
