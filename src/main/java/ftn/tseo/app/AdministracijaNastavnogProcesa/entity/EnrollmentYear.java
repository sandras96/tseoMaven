package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="enrollmentYear")
public class EnrollmentYear {

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="enrollmentYear_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="year", unique=true, nullable=false, length=10)
	private String year;
	
	@Column(name="dateStart", nullable=false)
	private Date dateStart;
	
	@Column(name="dateEnd", nullable=false)
	private Date dateEnd;
	
	@Column(name="status", columnDefinition="BOOLEAN DEFAULT TRUE")
	private boolean status;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="enrollmentYear")
	private Set<CourseAttendance> courseAttendances = new HashSet<CourseAttendance>();
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="enrollmentYear")
	private Set<CourseProfessor> courseProfessors = new HashSet<CourseProfessor>();
	
	
	
	public EnrollmentYear() {
		super();
	}

	public EnrollmentYear(Integer id, String year, Date dateStart, Date dateEnd, boolean status,
			Set<CourseAttendance> courseAttendances, Set<CourseProfessor> courseProfessors) {
		super();
		this.id = id;
		this.year = year;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.status = status;
		this.courseAttendances = courseAttendances;
		this.courseProfessors = courseProfessors;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public Date getDateStart() {
		return dateStart;
	}


	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}


	public Date getDateEnd() {
		return dateEnd;
	}


	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
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
	
	
	
}
