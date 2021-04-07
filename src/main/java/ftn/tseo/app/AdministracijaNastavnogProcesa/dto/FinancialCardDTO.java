package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.FinancialCard;

public class FinancialCardDTO {
	

	private Integer id;
	private String accountNumber;
	private Integer model;
	private double balance;
	private String reference;
	private StudentDTO student;
	
	
	public FinancialCardDTO() {
		super();
	}

	public FinancialCardDTO(FinancialCard financialCard) {
		this(financialCard.getId(), financialCard.getAccountNumber(), financialCard.getModel(), financialCard.getBalance(), financialCard.getReference(), new StudentDTO(financialCard.getStudent()));
	}
	public FinancialCardDTO(Integer id, String accountNumber, Integer model, double balance, String reference, StudentDTO student) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.model = model;
		this.balance = balance;
		this.reference = reference;
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Integer getModel() {
		return model;
	}

	public String getReference() {
		return reference;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	



}
