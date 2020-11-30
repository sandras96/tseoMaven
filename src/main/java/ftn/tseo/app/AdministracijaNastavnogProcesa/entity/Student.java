package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="student_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="index_number", unique=true, nullable=false, length=15)
	private String indexNum;
	
	@Column(name="birthdate", unique= false, nullable=false)
	private Date birthdate;
	
	@Column(name="address", unique=false, nullable=false)
	private String address;
	
	@Column(name="city", unique=false, nullable=false, length=30)
	private String city;
	
	@Column(name="zip", unique=false, nullable=false)
	private Integer zip;
	
	@Column(name="country", unique=false, nullable=false)
	private String country;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="student")
	private Set<Document> documents = new HashSet<Document>();
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="student")
	private Set<Payment> payments = new HashSet<Payment>();
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="student")
	private Set<CourseAttendance> courseAttendances = new HashSet<CourseAttendance>();
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="student")
	private Set<ExamTaking> examTakings = new HashSet<ExamTaking>();

	public Student() {
		super();
	}

	public Student(Integer id, String indexNum, Date birthdate, String address, String city, Integer zip, String country,
			User user, Set<Document> documents, Set<Payment> payments, Set<CourseAttendance> courseAttendances,
			Set<ExamTaking> examTakings) {
		super();
		this.id = id;
		this.indexNum = indexNum;
		this.birthdate = birthdate;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.user = user;
		this.documents = documents;
		this.payments = payments;
		this.courseAttendances = courseAttendances;
		this.examTakings = examTakings;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(String indexNum) {
		this.indexNum = indexNum;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	
}
