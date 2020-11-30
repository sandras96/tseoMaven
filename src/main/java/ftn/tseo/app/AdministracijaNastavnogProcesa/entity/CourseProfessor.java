package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="courseProfessor")
public class CourseProfessor {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="courseProf_id", unique=true, nullable=false)
	private Integer id;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="enrollmentYear_id")
	private EnrollmentYear enrollmentYear;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="professor_id")
	private Professor professor;

	
	
	public CourseProfessor() {
		super();
	}

	public CourseProfessor(Integer id, EnrollmentYear enrollmentYear, Course course, Professor professor) {
		super();
		this.id = id;
		this.enrollmentYear = enrollmentYear;
		this.course = course;
		this.professor = professor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EnrollmentYear getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(EnrollmentYear enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	
	
}
