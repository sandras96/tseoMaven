package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="payment_id", unique= true, nullable=false)
	private Integer id;
	
	@Column(name="name", unique=false, nullable=false, length=50)
	private String name;
	
	@Column(name="addres", unique=false, nullable=false)
	private String address;
	
	@Column(name="city", unique=false, nullable=false, length=30)
	private String city;
	
	@Column(name="paymentCode", unique=false, nullable=false)
	private Integer paymentCode;
	
	@Column(name="amount", unique=false, nullable=false)
	private double amount;
	
	@Column(name="purpose", unique=false, nullable=false, length=50)
	private String purpose;
	
	@Column(name="accountNumber", unique=false, nullable=false)
	private Integer accountNumber;
	
	@Column(name="model", unique=false, nullable=false)
	private Integer model;
	
	@Column(name="reference", unique=false, nullable=false)
	private Integer reference;
	
	@Column(name="date", unique=false, nullable=false)
	private Date date;
	
	@Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
	private Boolean deleted;
			
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="student_id")
	private Student student;
	
	

	public Payment() {
		super();
	}

	public Payment(Integer id, String name, String address, String city, Integer paymentCode, double amount,
			String purpose, Integer accountNumber, Integer model, Integer reference, Date date, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.paymentCode = paymentCode;
		this.amount = amount;
		this.purpose = purpose;
		this.accountNumber = accountNumber;
		this.model = model;
		this.reference = reference;
		this.date = date;
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(Integer paymentCode) {
		this.paymentCode = paymentCode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public Integer getReference() {
		return reference;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}	
	
	
	
	

}
