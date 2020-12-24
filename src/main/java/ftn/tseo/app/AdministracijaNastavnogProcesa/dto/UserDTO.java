package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.List;
import java.util.Set;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Authority;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;

public class UserDTO {
	
	private Integer id;
	private String username;
	private String password;
	private boolean deleted;
	private Set<Authority> authorities;
	private StudentDTO student;
	private ProfessorDTO professor;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User user) {
		this(user.getId(), user.getUsername(), user.getPassword(), user.isDeleted() , user.getUser_authorities());
	}
	

	public UserDTO(Integer id, String username, String password,
			boolean deleted , Set<Authority> authorities ) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.deleted = deleted;
		this.authorities = authorities;
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
	

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", deleted=" + deleted + "]";
	}

	
	

}
