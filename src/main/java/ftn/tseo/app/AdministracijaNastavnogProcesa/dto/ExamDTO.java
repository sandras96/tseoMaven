package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Date;
import java.util.Set;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;

public class ExamDTO {
	
	private Integer id;
	private Date date;
	private float points;
	private CourseDTO course;
	private String assignment;
	private Set<ExamTakingDTO> examTakings;
	private ExamPeriodDTO examPeriod;
	
	public ExamDTO() {
		
	}

	public ExamDTO(Exam exam) {
		this(exam.getId(), exam.getDate(), exam.getPoints(), new CourseDTO(exam.getCourse()),exam.getAssignment(), new ExamPeriodDTO(exam.getExamPeriod()));
	}

	
	public ExamDTO(Integer id, Date date, float points, CourseDTO course,String assignment,
			Set<ExamTakingDTO> examTakings, ExamPeriodDTO examPeriod) {
		super();
		this.id = id;
		this.date = date;
		this.points = points;
		this.course = course;
		this.assignment = assignment;
		this.examTakings = examTakings;
		this.examPeriod = examPeriod;
	}

	
	public ExamDTO(Integer id, Date date, float points, CourseDTO course, String assignment, ExamPeriodDTO examPeriod) {
		super();
		this.id = id;
		this.date = date;
		this.points = points;
		this.course = course;
		this.assignment = assignment;
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

	public CourseDTO getCourse() {
		return course;
	}

	public void setCourse(CourseDTO course) {
		this.course = course;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public ExamPeriodDTO getExamPeriod() {
		return examPeriod;
	}

	public void setExamPeriod(ExamPeriodDTO examPeriod) {
		this.examPeriod = examPeriod;
	}

	
}
