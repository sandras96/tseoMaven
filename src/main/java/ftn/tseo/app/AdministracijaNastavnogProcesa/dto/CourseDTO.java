package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Set;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course.Semester;

public class CourseDTO {
	
	private Integer id;
	private String name;
	private float espb;
	private Semester semester;
	private boolean deleted;
	private Set<CourseAttendanceDTO> courseAttendances;

	
	public CourseDTO() {
		
	}

	public CourseDTO(Course course) {
		this(course.getId(), course.getName(), course.getEspb(), course.getSemester(),course.isDeleted());
	}

	
	
	public CourseDTO(Integer id, String name, float espb, Semester semester, boolean deleted
			/*Set<CourseAttendanceDTO> courseAttendances*/) {
		this.id = id;
		this.name = name;
		this.espb = espb;
		this.semester = semester;
		this.deleted = deleted;
//		this.courseAttendances = courseAttendances;
	}


	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getEspb() {
		return espb;
	}

	public Semester getSemester() {
		return semester;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public Set<CourseAttendanceDTO> getCourseAttendances() {
		return courseAttendances;
	}
	

	
}
