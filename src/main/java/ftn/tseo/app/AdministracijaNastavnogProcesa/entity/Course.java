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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	private boolean deleted;
	
	@OneToMany(cascade= {CascadeType.REFRESH}, fetch= FetchType.LAZY, mappedBy="course")
	private Set<CourseAttendance> courseAttendances = new HashSet<CourseAttendance>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "courseProfessor", 
        joinColumns = @JoinColumn(name = "course_id"), 
        inverseJoinColumns =  @JoinColumn(name = "professor_id") 
    )
    private Set<Professor> professors = new HashSet<Professor>();
	
	@OneToMany(cascade= {CascadeType.REFRESH}, fetch= FetchType.LAZY, mappedBy="course")
	private Set<Exam> exams = new HashSet<Exam>();
	
	
	public Course() {
		super();
	}

	public Course(Integer id, String name, float espb, Semester semester, boolean deleted,
			Set<CourseAttendance> courseAttendances, Set<Professor> professors, Set<Exam> exams) {
		super();
		this.id = id;
		this.name = name;
		this.espb = espb;
		this.semester = semester;
		this.deleted = deleted;
		this.courseAttendances = courseAttendances;
		this.professors = professors;
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


	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Set<CourseAttendance> getCourseAttendances() {
		return courseAttendances;
	}


	public void setCourseAttendances(Set<CourseAttendance> courseAttendances) {
		this.courseAttendances = courseAttendances;
	}

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
	
	
	
	

}
