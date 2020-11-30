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
@Table(name="courseAttendance")
public class CourseAttendance {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="courseAttendance_id", unique=true, nullable=false)
	private Integer id;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="student_id")
	private Student student;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="enrollmentYear_id")
	private EnrollmentYear enrollmentYear;

	
	public CourseAttendance() {
		super();
	}

	public CourseAttendance(Integer id, Student student, Course course, EnrollmentYear enrollmentYear) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.enrollmentYear = enrollmentYear;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public EnrollmentYear getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(EnrollmentYear enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}
	
	

}
