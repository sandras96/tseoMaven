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
@Table(name="examTaking")
public class ExamTaking {

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="examTaking_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="points", unique=false, nullable=false)
	private float points;
	
	@Column(name="mark", unique=false, nullable=false)
	private Integer mark;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="exam_id", nullable=true)
	private Exam exam;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="student_id", nullable=true)
	private Student student;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="professor_id", nullable=true)
	private Professor professor;

	
	public ExamTaking() {
		super();
	}

	public ExamTaking(Integer id, float points, Integer mark, Exam exam, Student student,
			Professor professor) {
		super();
		this.id = id;
		this.points = points;
		this.mark = mark;
		this.exam = exam;
		this.student = student;
		this.professor = professor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
}
