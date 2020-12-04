package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamTaking;

public class ExamTakingDTO {
	
	private Integer id;
	private boolean pass;
	private float points;
	private Integer mark;
	private ExamDTO exam;
	private StudentDTO student;
	private ProfessorDTO professor;
	
	
	public ExamTakingDTO() {
		
	}

	public ExamTakingDTO(ExamTaking examTaking) {
		this(examTaking.getId(), examTaking.isPass(), examTaking.getPoints(), examTaking.getMark(),
				new ExamDTO(examTaking.getExam()), new StudentDTO(examTaking.getStudent()), new ProfessorDTO(examTaking.getProfessor()));
	}
	
	
	public ExamTakingDTO(Integer id, boolean pass, float points, Integer mark, ExamDTO exam, StudentDTO student,
			ProfessorDTO professor) {
		super();
		this.id = id;
		this.pass = pass;
		this.points = points;
		this.mark = mark;
		this.exam = exam;
		this.student = student;
		this.professor = professor;
	}

	public Integer getId() {
		return id;
	}

	public boolean isPass() {
		return pass;
	}

	public float getPoints() {
		return points;
	}

	public Integer getMark() {
		return mark;
	}

	public ExamDTO getExam() {
		return exam;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public ProfessorDTO getProfessor() {
		return professor;
	}

	
}
