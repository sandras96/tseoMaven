package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Assignment;

public class AssignmentDTO {

	private Integer id;
	private String name;
	private float points;
	private ExamDTO exam;
	
	
	public AssignmentDTO() {
	}

	public AssignmentDTO(Assignment assignment) {
		this(assignment.getId(), assignment.getName(), assignment.getPoints(), new ExamDTO(assignment.getExam()));
	}

	public AssignmentDTO(Integer id, String name, float points, ExamDTO exam) {
		this.id = id;
		this.name = name;
		this.points = points;
		this.exam = exam;
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

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public ExamDTO getExam() {
		return exam;
	}

	public void setExam(ExamDTO exam) {
		this.exam = exam;
	}

	
	
	
	
}
