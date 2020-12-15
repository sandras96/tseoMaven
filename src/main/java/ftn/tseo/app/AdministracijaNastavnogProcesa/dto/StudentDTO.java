package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Date;
import java.util.Set;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;

public class StudentDTO {
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String indexNum;
	private Date birthDate;
	private String address;
	private String city;
	private Integer zip;
	private String country;
	private String email;
	private String phone;
	private UserDTO user;
	private Set<DocumentDTO> documents;
	private Set<PaymentDTO> payments;
	private Set<CourseAttendanceDTO> courseAttendances;
	private Set<ExamTakingDTO> examTakings;
	
	
	public StudentDTO() {

	}

	public StudentDTO(Student student) {
		this(student.getPerson_id(), student.getFirstname(), student.getLastname(),student.getIndexNum(), student.getBirthdate(), student.getAddress(),
		student.getCity(), student.getZip(), student.getCountry(), student.getEmail(), student.getPhone(), new UserDTO(student.getUser()));
	}

	public StudentDTO(Integer id, String firstname, String lastname, String indexNum, Date birthDate, String address, String city, Integer zip,
			String country, String email, String phone, UserDTO user) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.indexNum = indexNum;
		this.birthDate = birthDate;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.user = user;
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

	public String getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(String indexNum) {
		this.indexNum = indexNum;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", indexNum=" + indexNum
				+ ", birthDate=" + birthDate + ", address=" + address + ", city=" + city + ", zip=" + zip + ", country="
				+ country + ", email=" + email + ", phone=" + phone + ", user=" + user + ", documents=" + documents
				+ ", payments=" + payments + ", courseAttendances=" + courseAttendances + ", examTakings=" + examTakings
				+ "]";
	}



	
	
	

}
