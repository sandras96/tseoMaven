package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Date;
import java.util.Set;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;

public class StudentDTO {
	
	private Integer id;
	private String indexNum;
	private Date birthDate;
	private String address;
	private String city;
	private Integer zip;
	private String country;
	private UserDTO user;
	private Set<DocumentDTO> documents;
	private Set<PaymentDTO> payments;
	private Set<CourseAttendanceDTO> courseAttendances;
	private Set<ExamTakingDTO> examTakings;
	
	
	public StudentDTO() {

	}

	public StudentDTO(Student student) {
		this(student.getId(), student.getIndexNum(), student.getBirthdate(), student.getAddress(),
		student.getCity(), student.getZip(), student.getCountry(), new UserDTO(student.getUser()));
	}

	public StudentDTO(Integer id, String indexNum, Date birthDate, String address, String city, Integer zip,
			String country, UserDTO user) {
		super();
		this.id = id;
		this.indexNum = indexNum;
		this.birthDate = birthDate;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.user = user;
	}



	public StudentDTO(Integer id, String indexNum, Date birthDate, String address, String city, Integer zip,
			String country, UserDTO user, Set<DocumentDTO> documents, Set<PaymentDTO> payments,
			Set<CourseAttendanceDTO> courseAttendances, Set<ExamTakingDTO> examTakings) {
		super();
		this.id = id;
		this.indexNum = indexNum;
		this.birthDate = birthDate;
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

	public String getIndexNum() {
		return indexNum;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public Integer getZip() {
		return zip;
	}

	public String getCountry() {
		return country;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIndexNum(String indexNum) {
		this.indexNum = indexNum;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	
	
	

}
