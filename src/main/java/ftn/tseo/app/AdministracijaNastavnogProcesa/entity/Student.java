package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="student")
@AttributeOverride(name="id", column=@Column(name="student_id"))
//@NamedQuery(name = "Student.findById", query = "select s from Student u where s.student_id = ?1")
public class Student extends Person{
	
	
	
	@Column(name="index_number", unique=true, nullable=false, length=15)
	private String indexNum;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY)
	@JoinColumn(name="userRel", referencedColumnName="user_id", unique=true)
	private User user;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="student")
	private Set<Document> documents = new HashSet<Document>();
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="student")
	private Set<Payment> payments = new HashSet<Payment>();
	
	@OneToMany(cascade= {CascadeType.REFRESH}, fetch= FetchType.LAZY, mappedBy="student")
	private Set<CourseAttendance> courseAttendances = new HashSet<CourseAttendance>();
	
	@OneToMany(cascade= {CascadeType.REFRESH}, fetch= FetchType.LAZY, mappedBy="student")
	private Set<ExamTaking> examTakings = new HashSet<ExamTaking>();

	public Student() {
		super();
	}

	

	public Student(String indexNum, User user, Set<Document> documents, Set<Payment> payments,
			Set<CourseAttendance> courseAttendances, Set<ExamTaking> examTakings) {
		super();
		this.indexNum = indexNum;
		this.user = user;
		this.documents = documents;
		this.payments = payments;
		this.courseAttendances = courseAttendances;
		this.examTakings = examTakings;
	}


	public String getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(String indexNum) {
		this.indexNum = indexNum;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public Set<CourseAttendance> getCourseAttendances() {
		return courseAttendances;
	}

	public void setCourseAttendances(Set<CourseAttendance> courseAttendances) {
		this.courseAttendances = courseAttendances;
	}

	public Set<ExamTaking> getExamTakings() {
		return examTakings;
	}

	public void setExamTakings(Set<ExamTaking> examTakings) {
		this.examTakings = examTakings;
	}


	@Override
	public String toString() {
		return "Student [indexNum=" + indexNum + ", user=" + user + ", documents=" + documents + ", payments="
				+ payments + ", courseAttendances=" + courseAttendances + ", examTakings=" + examTakings + "]";
	}

	
}
