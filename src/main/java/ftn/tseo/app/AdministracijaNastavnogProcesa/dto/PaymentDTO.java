package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Date;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Payment;

public class PaymentDTO {
	
	private Integer id;
	private String name;
	private String address;
	private String city;
	private Integer paymentCode;
	private double amount;
	private String purpose;
	private Integer accountNumber;
	private Integer model;
	private Integer refference;
	private Date date;
	private boolean deleted;
	private StudentDTO student;
	
	
	public PaymentDTO() {
		
	}

	public PaymentDTO(Payment p) {
		this(p.getId(), p.getName(), p.getAddress(), p.getCity(), p.getPaymentCode(), p.getAmount(), p.getPurpose(),
				p.getAccountNumber(),p.getModel(), p.getReference(),p.getDate(), p.isDeleted(), new StudentDTO(p.getStudent()));
	}

	public PaymentDTO(Integer id, String name, String address, String city, Integer paymentCode, double amount,
			String purpose, Integer accountNumber, Integer model, Integer refference, Date date, boolean deleted,
			StudentDTO student) {
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
		this.refference = refference;
		this.date = date;
		this.deleted = deleted;
		this.student = student;
	}


	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getAddress() {
		return address;
	}


	public String getCity() {
		return city;
	}


	public Integer getPaymentCode() {
		return paymentCode;
	}


	public double getAmount() {
		return amount;
	}


	public String getPurpose() {
		return purpose;
	}


	public Integer getAccountNumber() {
		return accountNumber;
	}


	public Integer getModel() {
		return model;
	}


	public Integer getRefference() {
		return refference;
	}


	public Date getDate() {
		return date;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public StudentDTO getStudent() {
		return student;
	}
	
	

}
