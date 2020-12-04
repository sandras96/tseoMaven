package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="user_id", unique= true, nullable=false)
	private Integer id;
	
	@Column(name="firstname", unique=false, nullable=false, length=20)
	private String firstname;
	
	@Column(name="lastname", unique=false, nullable=false, length=30)
	private String lastname;
	
	@Column(name="username", unique=true, nullable=false, length=30)
	private String username;
	
	@Column(name="password", unique=false, nullable=false)
	private String password;
	
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	@Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
	private boolean deleted;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy = "user")
	private Student student;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy = "user")
	private Professor professor;
	
	
	
	public User() {
		super();
	}
	

	public User(Integer id, String firstname, String lastname, String username, String password, String email,
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
