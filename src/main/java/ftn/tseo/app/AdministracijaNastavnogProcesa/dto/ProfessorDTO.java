package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Set;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor.Role;

public class ProfessorDTO {

	private Integer id;
	private Role role;
	private UserDTO user;
	private Set<ExamTakingDTO> examTakings;
	private Set<CourseDTO> courses;
	
	public ProfessorDTO() {
		
	}
	
	public ProfessorDTO(Professor professor) {
		this(professor.getId(), professor.getRole(), new UserDTO(professor.getUser()));
	}

	public ProfessorDTO(Integer id, Role role,
			UserDTO user/* , Set<ExamTakingDTO> examTakings, Set<CourseDTO> courses */) {
		super();
		this.id = id;
		this.role = role;
		this.user = user;
		/*
		 * this.examTakings = examTakings; this.courses = courses;
		 */
	}

	public Integer getId() {
		return id;
	}

	public Role getRole() {
		return role;
	}

	public UserDTO getUser() {
		return user;
	}

	public Set<ExamTakingDTO> getExamTakings() {
		return examTakings;
	}

	public Set<CourseDTO> getCourses() {
		return courses;
	}
	
	
}
