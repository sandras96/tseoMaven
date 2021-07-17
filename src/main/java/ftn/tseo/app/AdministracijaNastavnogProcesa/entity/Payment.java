package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="payment_id", unique= true, nullable=false)
	private Integer id;
	
	@Column(name="amount", unique=false, nullable=false)
	private double amount;
	
	@Column(name="purpose", unique=false, nullable=false, length=50)
	private String purpose;
	
	@Column(name="date", unique=false, nullable=false)
	private Date date;
	
	@Column(name="name", unique=false, nullable=false)
	private String name;
	
	@Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
	private boolean deleted;
			
	@ManyToOne
	@JoinColumn(name="financialCard_id")
	private FinancialCard financialCard;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY)
	@JoinColumn(name="creditCard_Id", referencedColumnName="creditCard_id", unique=true)
	private CreditCard creditCard;

	public Payment() {
		super();
	}

	public Payment(Integer id, double amount, String purpose, Date date, String name, boolean deleted, FinancialCard financialCard,
			CreditCard creditCard) {
		super();
		this.id = id;
		this.amount = amount;
		this.purpose = purpose;
		this.date = date;
		this.name = name;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public FinancialCard getFinancialCard() {
		return financialCard;
	}

	public void setFinancialCard(FinancialCard financialCard) {
		this.financialCard = financialCard;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	
	

}
