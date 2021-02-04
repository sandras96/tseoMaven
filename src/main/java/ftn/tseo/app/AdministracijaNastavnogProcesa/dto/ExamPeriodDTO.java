package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Date;
import java.util.Set;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamPeriod;

public class ExamPeriodDTO {

	private Integer id;
	private String name;
	private Date startDate;
	private Date endDate;
	private boolean deleted;
	private Set<ExamDTO> exams;
	
	public ExamPeriodDTO() {
		
	}
	
	public ExamPeriodDTO(ExamPeriod examPeriod) {
		this(examPeriod.getId(), examPeriod.getName(), examPeriod.getStartDate(), examPeriod.getEndDate(), examPeriod.isDeleted());
	}
	

	public ExamPeriodDTO(Integer id, String name, Date startDate, Date endDate, boolean deleted) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.deleted = deleted;
		this.endDate = endDate;
	}

	public ExamPeriodDTO(Integer id, String name, Date startDate, Date endDate, Set<ExamDTO> exams) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.exams = exams;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Set<ExamDTO> getExams() {
		return exams;
	}

	public void setExams(Set<ExamDTO> exams) {
		this.exams = exams;
	}

	
}
