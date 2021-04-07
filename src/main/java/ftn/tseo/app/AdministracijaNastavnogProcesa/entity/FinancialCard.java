package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="financialcard")
public class FinancialCard {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="financialCard_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="account_number", unique=true, nullable=false)
	private String accountNumber;
	
	@Column(name="reference", unique=true, nullable=false, length=20)
	private String reference;
	
	@Column(name="model", unique=false, nullable=false)
	private Integer model;
	
	@Column(name="balance", unique=false, nullable=true)
	private double balance;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY)
	@JoinColumn(name="student_id", referencedColumnName="student_id", unique=true)
	private Student student;
	
	@OneToMany(mappedBy="financialCard")
	private Set<Payment> payments = new HashSet<Payment>();

	public FinancialCard() {
		super();
	}

	public FinancialCard(String accountNumber, String reference, Integer model, double balance, Student student) {
		super();
		this.accountNumber = accountNumber;
		this.reference = reference;
		this.model = model;
		this.balance = balance;
		this.student = student;
	}

	public FinancialCard(Integer id, String accountNumber, String reference, Integer model, double balance,
			Student student) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.reference = reference;
		this.model = model;
		this.balance = balance;
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	
	public static String getRandomAccountNumber(){
		 Random rand = new Random();
		 String startsWith = "840-";
		 for (int i = 0; i < 7; i++)
		    {
		        int n = rand.nextInt(10) + 0;
		        startsWith += Integer.toString(n);
		    }
		 startsWith += "-";
		 for (int i = 0; i <2; i++)
		    {
			 	int n = rand.nextInt(10) + 0;
			 	startsWith += Integer.toString(n);
		    }
		 return startsWith;
	}
	
	public static String getRandomReference(){
		 Random rand = new Random();
		 String ref = "";
		 for (int i = 0; i < 16; i++)
		    {
		        int n = rand.nextInt(10) + 0;
		        ref += Integer.toString(n);
		    }
		
		 return ref;
	}
	

}
