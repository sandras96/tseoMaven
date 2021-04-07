package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Date;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CreditCard;

public class CreditCardDTO {
	
	private Integer id;
	private String name;
	private Integer cardNumber;
	private Date valid;
	private Integer cvc;

	
	public CreditCardDTO() {
		super();
	}

	public CreditCardDTO(CreditCard creditCard) {
		this(creditCard.getId(), creditCard.getName(), creditCard.getCardNumber(), creditCard.getValid(), creditCard.getCvc()/*, new PaymentDTO(creditCard.getPayment())*/);
	}
	
	public CreditCardDTO(Integer id, String name, Integer cardNumber, Date valid, Integer cvc) {
		super();
		this.id = id;
		this.name = name;
		this.cardNumber = cardNumber;
		this.valid = valid;
		this.cvc = cvc;
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

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getValid() {
		return valid;
	}

	public void setValid(Date valid) {
		this.valid = valid;
	}

	public Integer getCvc() {
		return cvc;
	}

	public void setCvc(Integer cvc) {
		this.cvc = cvc;
	}

	
}
