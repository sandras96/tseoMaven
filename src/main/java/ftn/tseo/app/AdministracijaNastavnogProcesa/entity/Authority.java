package ftn.tseo.app.AdministracijaNastavnogProcesa.entity;

import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;

@Entity
@Table(name="authority")
public class Authority/* implements GrantedAuthority */{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="name")
	private EAuthority name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EAuthority getName() {
		return name;
	}

	public void setName(EAuthority name) {
		this.name = name;
	}

	/*
	 * @Override public String getAuthority() { return name; }
	 */

	

	
	

}