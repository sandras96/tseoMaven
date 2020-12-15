package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "user")

public class User implements Serializable, UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="user_id", unique= true, nullable=false)
	private Integer id;
	
	@Column(name="username", unique=true, nullable=false, length=30)
	private String username;
	
	@Column(name="password", unique=false, nullable=false)
	private String password;
	
	@Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
	private boolean deleted;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy = "user")
	private Student student;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy = "user")
	private Professor professor;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="user_authority",
			joinColumns=@JoinColumn(name="user_id",referencedColumnName="user_id"),
			inverseJoinColumns = @JoinColumn(name="authority_id",referencedColumnName="id"))
	private Set<Authority> user_authorities = new HashSet<>();
	
	public User() {
		super();
	}
	

	public User(Integer id, String username, String password, boolean deleted, Student student, Professor professor,
			Set<Authority> user_authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.deleted = deleted;
		this.student = student;
		this.professor = professor;
		this.user_authorities = user_authorities;
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

	public Set<Authority> getUser_authorities() {
		return user_authorities;
	}


	public void setUser_authorities(Set<Authority> user_authorities) {
		this.user_authorities = user_authorities;
	}


	@Override
	 public Collection<? extends GrantedAuthority> getAuthorities() {
		 return this.user_authorities;
	 }
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getauthorities() {
		String authority= null;
      for (GrantedAuthority s : user_authorities ) {
          authority = s.getAuthority();
      }
		return authority;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", deleted=" + deleted + "]";
	}

	/*
	 * public Student getStudent() { return student; }
	 * 
	 * public void setStudent(Student student) { this.student = student; }
	 * 
	 * public Professor getProfessor() { return professor; }
	 * 
	 * public void setProfessor(Professor professor) { this.professor = professor; }
	 * 
	 */
	

}
