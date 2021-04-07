package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="creditcard")
public class CreditCard {

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="creditCard_id", unique= true, nullable=false)
	private Integer id;
	
	@Column(name="name", unique= false, nullable=false, length=50)
	private String name;
	
	@Column(name="cardNumber", unique= false, nullable=false)
	private Integer cardNumber;
	
	@Column(name="valid", unique= false, nullable=false)
	private Date valid;
	
	@Column(name="cvc", unique= false, nullable=false)
	private Integer cvc;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy = "creditCard")
	private Payment payment;

	
	public CreditCard() {
		super();
	}

	public CreditCard(Integer id, String name, Integer cardNumber, Date valid, Integer cvc, Payment payment) {
		super();
		this.id = id;
		this.name = name;
		this.cardNumber = cardNumber;
		this.valid = valid;
		this.cvc = cvc;
		this.payment = payment;
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

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
}
