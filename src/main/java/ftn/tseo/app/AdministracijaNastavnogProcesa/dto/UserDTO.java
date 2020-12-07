package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;

public class UserDTO {
	
	private Integer id;
	private String username;
	private String password;
	private boolean deleted;
	private String authority;
	private StudentDTO student;
	private ProfessorDTO professor;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User user) {
		this(user.getId(), user.getUsername(),user.getPassword(), user.isDeleted(), user.getauthorities());
	}
	

	public UserDTO(Integer id, String username, String password,
			boolean deleted, String authority) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.deleted = deleted;
	}

	public UserDTO(Integer id, String username, String password,
			boolean deleted, StudentDTO student, ProfessorDTO professor) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}
