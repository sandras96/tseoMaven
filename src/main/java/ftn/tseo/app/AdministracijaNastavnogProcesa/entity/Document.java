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
@Table(name="document")
public class Document {

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="document_id", unique= true, nullable= false)
	private Integer id;
	
	@Column(name="name", unique=false, nullable=false)
	private String name;
	
	@Column(name="date", unique= false, nullable=false)
	private Date date;
	
	@Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
	private boolean deleted;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="student_id")
	private Student student;
	
	
	
	public Document() {
		super();
	}

	public Document(Integer id, String name, Date date, boolean deleted, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.deleted = deleted;
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

	public Date getDate() {
		return date;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
	
}
