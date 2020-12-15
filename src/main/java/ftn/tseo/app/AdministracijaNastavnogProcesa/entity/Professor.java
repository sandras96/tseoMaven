package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;


import static javax.persistence.GenerationType.IDENTITY;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="professor")
@AttributeOverride(name="id", column=@Column(name="professor_id"))
public class Professor extends Person{
	
	public enum Role {
	    PROFESSOR, ASSOCIATE, DEMONSTRATOR;
	}
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=IDENTITY)
	 * 
	 * @Column(name="professor_id", unique=true, nullable=false) private Integer id;
	 */
	
	@Enumerated(EnumType.STRING)
	@Column(name="role", unique=false, nullable=false)
	private Role role;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY)
	@JoinColumn(name="userRel", referencedColumnName="user_id")
	private User user;
	
	@OneToMany(cascade= {CascadeType.REFRESH}, fetch= FetchType.LAZY, mappedBy="professor")
	private Set<ExamTaking> examTakings = new HashSet<ExamTaking>();
	
	@ManyToMany(mappedBy="professors")
	private Set<Course> courses = new HashSet<Course>();

	
	
	public Professor() {
		super();
	}

	public Professor(Role role, User user, Set<ExamTaking> examTakings, Set<Course> courses) {
		super();
		this.role = role;
		this.user = user;
		this.examTakings = examTakings;
		this.courses = courses;
	}




	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ExamTaking> getExamTakings() {
		return examTakings;
	}

	public void setExamTakings(Set<ExamTaking> examTakings) {
		this.examTakings = examTakings;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	
	

	
}
