package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	public enum Semester {
	    WINTER, SUMMER;
	}
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="course_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="name", unique=true, nullable=false, length=50)
	private String name;
	
	@Column(name="espb", unique=false, nullable=false)
	private float espb;
	
	@Enumerated(EnumType.STRING)
	@Column(name="semester", unique=false, nullable=false)
	private Semester semester;
	
	@Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
	private Boolean deleted;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="course")
	private Set<CourseAttendance> courseAttendances = new HashSet<CourseAttendance>();
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="course")
	private Set<CourseProfessor> courseProfessors = new HashSet<CourseProfessor>();
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="course")
	private Set<Exam> exams = new HashSet<Exam>();
	
	
	public Course() {
		super();
	}

	public Course(Integer id, String name, float espb, Semester semester, Boolean deleted,
			Set<CourseAttendance> courseAttendances, Set<CourseProfessor> courseProfessors, Set<Exam> exams) {
		super();
		this.id = id;
		this.name = name;
		this.espb = espb;
		this.semester = semester;
		this.deleted = deleted;
		this.courseAttendances = courseAttendances;
		this.courseProfessors = courseProfessors;
		this.exams = exams;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getEspb() {
		return espb;
	}


	public void setEspb(float espb) {
		this.espb = espb;
	}


	public Semester getSemester() {
		return semester;
	}


	public void setSemester(Semester semester) {
		this.semester = semester;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public Set<CourseAttendance> getCourseAttendances() {
		return courseAttendances;
	}


	public void setCourseAttendances(Set<CourseAttendance> courseAttendances) {
		this.courseAttendances = courseAttendances;
	}


	public Set<CourseProfessor> getCourseProfessors() {
		return courseProfessors;
	}


	public void setCourseProfessors(Set<CourseProfessor> courseProfessors) {
		this.courseProfessors = courseProfessors;
	}

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
	
	
	
	

}
