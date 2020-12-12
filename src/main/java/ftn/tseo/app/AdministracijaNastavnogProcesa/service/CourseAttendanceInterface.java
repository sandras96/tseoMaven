package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CourseAttendance;

public interface CourseAttendanceInterface {
	
	List<CourseAttendance> findCourseAttendanceByStudentId(Integer id);
	List<CourseAttendance> findCourseAttendanceByCourseId(Integer id);

}
