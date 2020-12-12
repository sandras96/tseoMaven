package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CourseAttendance;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.CourseAttendanceRepository;

@Service
public class CourseAttendanceService implements CourseAttendanceInterface{

	
	@Autowired
	CourseAttendanceRepository courseAttendanceRepository;

	public CourseAttendance findOne(Integer id) {
		return courseAttendanceRepository.findById(id).orElse(null);
	}
	
	public List<CourseAttendance> findAll() {
		return courseAttendanceRepository.findAll();
	}
	
	public Page<CourseAttendance> findAll(Pageable pageable) {
		return courseAttendanceRepository.findAll(pageable);
	}

	public CourseAttendance save(CourseAttendance courseAttendance) {
		return courseAttendanceRepository.save(courseAttendance);
	}

	public void remove(Integer id) {
		courseAttendanceRepository.deleteById(id);
	}
	
	@Override
	public List<CourseAttendance> findCourseAttendanceByStudentId(Integer id) {
		return courseAttendanceRepository.findCourseAttendanceByStudentId(id);
	}

	@Override
	public List<CourseAttendance> findCourseAttendanceByCourseId(Integer id) {
		return courseAttendanceRepository.findCourseAttendanceByCourseId(id);
	}
	
}
