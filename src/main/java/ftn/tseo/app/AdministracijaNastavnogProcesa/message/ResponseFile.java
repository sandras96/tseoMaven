package ftn.tseo.app.AdministracijaNastavnogProcesa.message;

import java.util.Date;


public class ResponseFile {
	
	private Integer id;
	private String name;
	private String url;
	private String type;
	private Date date;
	private long size;
	private Integer student;
	
	public ResponseFile(Integer id, String name, String url, String type, Date date, long size, Integer student) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.type = type;
		this.date = date;
		this.size = size;
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

	public String getUrl() {
		return url;
	}

	public String getType() {
		return type;
	}

	public long getSize() {
		return size;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Integer getStudent() {
		return student;
	}

	public void setStudent(Integer student) {
		this.student = student;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	  
	
	  

}
