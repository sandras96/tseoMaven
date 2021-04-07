package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Date;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Payment;

public class PaymentDTO {
	
	private Integer id;
	private double amount;
	private String purpose;
	private Date date;
	private boolean deleted;
	private FinancialCardDTO financialCard;
	private CreditCardDTO creditCard;
	
	
	public PaymentDTO() {
		
	}

	
	public PaymentDTO(Payment p) { 
			this(p.getId(), p.getAmount(), p.getPurpose(), p.getDate(), p.isDeleted(), new FinancialCardDTO(p.getFinancialCard()), new CreditCardDTO(p.getCreditCard())); }
	 

	public PaymentDTO(Integer id, double amount, String purpose, Date date, boolean deleted, FinancialCardDTO financialCard, CreditCardDTO creditCard) {
		super();
		this.id = id;
		this.amount = amount;
		this.purpose = purpose;
		this.date = date;
		this.deleted = deleted;
		this.financialCard = financialCard;
		this.creditCard = creditCard;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public FinancialCardDTO getFinancialCard() {
		return financialCard;
	}

	public void setFinancialCard(FinancialCardDTO financialCard) {
		this.financialCard = financialCard;
	}

	public CreditCardDTO getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardDTO creditCard) {
		this.creditCard = creditCard;
	}

	 
}
