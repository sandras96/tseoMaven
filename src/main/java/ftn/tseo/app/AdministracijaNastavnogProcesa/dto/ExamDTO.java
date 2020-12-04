package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Date;
import java.util.Set;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;

public class ExamDTO {
	
	private Integer id;
	private Date date;
	private float points;
	private CourseDTO course;
	private Set<AssignmentDTO> assignments;
	private Set<ExamTakingDTO> examTakings;
	private ExamPeriodDTO examPeriod;
	
	public ExamDTO() {
		
	}

	public ExamDTO(Exam exam) {
		this(exam.getId(), exam.getDate(), exam.getPoints(), new CourseDTO(exam.getCourse()), new ExamPeriodDTO(exam.getExamPeriod()));
	}

	
	public ExamDTO(Integer id, Date date, float points, CourseDTO course, Set<AssignmentDTO> assignments,
			Set<ExamTakingDTO> examTakings, ExamPeriodDTO examPeriod) {
		super();
		this.id = id;
		this.date = date;
		this.points = points;
		this.course = course;
		this.assignments = assignments;
		this.examTakings = examTakings;
		this.examPeriod = examPeriod;
	}

	
	public ExamDTO(Integer id, Date date, float points, CourseDTO course, ExamPeriodDTO examPeriod) {
		super();
		this.id = id;
		this.date = date;
		this.points = points;
		this.course = course;
		this.examPeriod = examPeriod;
	}

	public Integer getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public float getPoints() {
		return points;
	}

	public CourseDTO getCourse() {
		return course;
	}

	public ExamPeriodDTO getExamPeriod() {
		return examPeriod;
	}

	public Set<AssignmentDTO> getAssignments() {
		return assignments;
	}

	public Set<ExamTakingDTO> getExamTakings() {
		return examTakings;
	}
	
	
}
