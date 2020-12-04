package ftn.tseo.app.AdministracijaNastavnogProcesa.dto;

import java.util.Date;
import java.util.Set;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamPeriod;

public class ExamPeriodDTO {

	private Integer id;
	private String name;
	private Date startDate;
	private Date endDate;
	private Set<ExamDTO> exams;
	
	public ExamPeriodDTO() {
		
	}
	
	public ExamPeriodDTO(ExamPeriod examPeriod) {
		this(examPeriod.getId(), examPeriod.getName(), examPeriod.getStartDate(), examPeriod.getEndDate());
	}
	

	public ExamPeriodDTO(Integer id, String name, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
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

	public String getName() {
		return name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Set<ExamDTO> getExams() {
		return exams;
	}
	
	
	
}
