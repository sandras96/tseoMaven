package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamTaking;

public class ExamTakingDTO {
	
	private Integer id;
	private float points;
	private Integer mark;
	private ExamDTO exam;
	private StudentDTO student;
	private ProfessorDTO professor;
	
	
	public ExamTakingDTO() {
		
	}

	
	public ExamTakingDTO(ExamTaking examTaking) { 
			this(examTaking.getId(), examTaking.getPoints(), examTaking.getMark(),
				new ExamDTO(examTaking.getExam()), new StudentDTO(examTaking.getStudent()), new ProfessorDTO(examTaking.getProfessor())); }
	 
	
	
	public ExamTakingDTO(Integer id, float points, Integer mark, ExamDTO exam, StudentDTO student,
			ProfessorDTO professor) {
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

	public ExamDTO getExam() {
		return exam;
	}

	public void setExam(ExamDTO exam) {
		this.exam = exam;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public ProfessorDTO getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorDTO professor) {
		this.professor = professor;
	}


	
}
