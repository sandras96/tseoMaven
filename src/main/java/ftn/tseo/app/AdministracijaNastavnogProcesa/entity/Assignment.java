package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="assignment")
public class Assignment {
	
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="assignment_id", unique=true, nullable=false)
	private Integer id;

	@Column(name="name", unique=false, nullable=false)
	private String name;

	@Column(name="points", unique=false, nullable=false)
	private float points;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="exam_id")
	private Exam exam;

	
	
	public Assignment() {
		super();
	}

	public Assignment(Integer id, String name, float points, Exam exam) {
		super();
		this.id = id;
		this.name = name;
		this.points = points;
		this.exam = exam;
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

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	
}
