package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;

public class UserDTO {
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private boolean deleted;
	private StudentDTO student;
	private ProfessorDTO professor;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User user) {
		this(user.getId(), user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword(),
				user.getEmail(), user.isDeleted());
	}

	public UserDTO(Integer id, String firstname, String lastname, String username, String password, String email,
			boolean deleted) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.deleted = deleted;
	}

	public UserDTO(Integer id, String firstname, String lastname, String username, String password, String email,
			boolean deleted, StudentDTO student, ProfessorDTO professor) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.deleted = deleted;
		this.student = student;
		this.professor = professor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	
	

}
