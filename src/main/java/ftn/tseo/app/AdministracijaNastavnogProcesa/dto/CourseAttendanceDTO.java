package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CourseAttendance;

public class CourseAttendanceDTO {
	
	private Integer id;
	private StudentDTO student;
	private CourseDTO course;
	
	public CourseAttendanceDTO() {
		
	}
	
	public CourseAttendanceDTO(CourseAttendance courseAttendance) {
		this(courseAttendance.getId(), new StudentDTO(courseAttendance.getStudent()), new CourseDTO(courseAttendance.getCourse()));
	}
	
	public CourseAttendanceDTO(Integer id, StudentDTO student, CourseDTO course) {
		this.id = id;
		this.student = student;
		this.course = course;
	}

	public Integer getId() {
		return id;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public CourseDTO getCourse() {
		return course;
	}
	
	

}
