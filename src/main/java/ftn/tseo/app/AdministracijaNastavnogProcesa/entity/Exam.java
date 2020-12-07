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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="exam")
public class Exam {

	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="exam_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="date", unique=false, nullable=false)
	private Date date;
	
	@Column(name="points", unique=false, nullable=false)
	private float points;
	
	@Column(name="assignment", unique=false, nullable=false)
	private String assignment;
	
	@ManyToOne(cascade= {CascadeType.REFRESH},fetch= FetchType.EAGER)
	@JoinColumn(name="course_id")
	private Course course;
	
	@OneToMany(cascade= {CascadeType.REFRESH}, fetch= FetchType.LAZY, mappedBy="exam")
	private Set<ExamTaking> examTaking = new HashSet<ExamTaking>();

	@ManyToOne(cascade= {CascadeType.REFRESH},fetch= FetchType.EAGER)
	@JoinColumn(name="examPeriod_id")
	private ExamPeriod examPeriod;
	
	
	public Exam() {
		super();
	}


	public Exam(Integer id, Date date, float points, Course course, String assignment,
			Set<ExamTaking> examTaking, ExamPeriod examPeriod) {
		super();
		this.id = id;
		this.date = date;
		this.points = points;
		this.course = course;
		this.assignment = assignment;
		this.examTaking = examTaking;
		this.examPeriod = examPeriod;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}


	public Set<ExamTaking> getExamTaking() {
		return examTaking;
	}

	public void setExamTaking(Set<ExamTaking> examTaking) {
		this.examTaking = examTaking;
	}


	public ExamPeriod getExamPeriod() {
		return examPeriod;
	}

	public void setExamPeriod(ExamPeriod examPeriod) {
		this.examPeriod = examPeriod;
	}

	
	
}

