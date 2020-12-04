package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Date;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Document;

public class DocumentDTO {

	private Integer id;
	private String name;
	private Date date;
	private boolean deleted;
	private StudentDTO student;
	
	public DocumentDTO() {
		
	}
	
	public DocumentDTO(Document document) {
		this(document.getId(), document.getName(), document.getDate(), document.isDeleted(), new StudentDTO(document.getStudent()));
	}

	public DocumentDTO(Integer id, String name, Date date, boolean deleted, StudentDTO student) {
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

	public String getName() {
		return name;
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
