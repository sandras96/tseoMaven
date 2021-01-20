package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "file")
public class FileDB {

	  @Id
	  @GeneratedValue(strategy=IDENTITY)
	  @Column(name="file_id", unique= true, nullable= false)
	  private Integer id;
	  
	  @Column(name="name", nullable=false)
	  private String name;
	  
	  @Column(name="type", nullable=false)
	  private String type;
	  
	  @Column(name="date", nullable = false)
	  private Date date;

	  //LOB is datatype for storing large object data
	  @Lob
	  @Column(name="data", nullable=false)
	  private byte[] data;
	  
	  @ManyToOne(fetch= FetchType.EAGER)
	  @JoinColumn(name="student_id")
	  private Student student;
		
	  
	  public FileDB() {
		  super();
	  }

	  public FileDB(String name, String type, Date date, byte[] data, Student student) {
	    this.name = name;
	    this.type = type;
	    this.date = date;
	    this.data = data;
	    this.student = student;
	    
	  }

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getData() {
		return data;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	



	  
}
