package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Date;
import java.util.Set;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor.Role;

public class ProfessorDTO {

	private Integer id;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private String address;
	private String city;
	private Integer zip;
	private String country;
	private String email;
	private String phone;
	private Role role;
	private UserDTO user;
	private Set<ExamTakingDTO> examTakings;
	private Set<CourseDTO> courses;
	
	public ProfessorDTO() {
		
	}
	
	public ProfessorDTO(Professor professor) {
		this(professor.getPerson_id(), professor.getFirstname(), professor.getLastname(), professor.getBirthdate(),
			 professor.getAddress(), professor.getCity(), professor.getZip(), professor.getCountry(), professor.getEmail(),
			 professor.getPhone(),professor.getRole(), new UserDTO(professor.getUser()));
		
	}



	public ProfessorDTO(Integer id, String firstname, String lastname, Date birthdate, String address, String city,
			Integer zip, String country, String email, String phone, Role role, UserDTO user) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.role = role;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	
	
	
}