package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id", updatable = false, nullable = false)
	    private Integer id;
		
		@Column(name="firstname", unique=false, nullable=false, length=20)
		private String firstname;
		
		@Column(name="lastname", unique=false, nullable=false, length=30)
		private String lastname;
		
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
		
		@Column(name="email", unique=true, nullable=false)
		private String email;
		
		@Column(name="phone", unique=true, nullable=false)
		private String phone;
		
//		@Version
//		@Column(name = "version")
//		private int version;   

		public Integer getPerson_id() {
			return id;
		}

		public void setPerson_id(Integer person_id) {
			this.id = person_id;
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

		@Override
		public String toString() {
			return "Person [person_id=" + id + ", firstname=" + firstname + ", lastname=" + lastname
					+ ", birthdate=" + birthdate + ", address=" + address + ", city=" + city + ", zip=" + zip
					+ ", country=" + country + ", email=" + email + ", phone=" + phone + "]";
		}

		
		
		
		
	   
		
	    
	    
}
