package core.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CAR")
public class Car implements java.io.Serializable {
	
	@Id 
	@Column(name = "chasseId", nullable = false)
	private String chasseId;
	
	@OneToOne(targetEntity=Person.class)
	private String JMBG;
		
	@Column(name = "mark", nullable = false)
	private String mark;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "licencePlate", nullable = false)
	private String licencePlate;
	
	@Column(name = "age", nullable = false)
	private Date age;
	
	public String getChasseId() {
		return chasseId;
	}
	public void setChasseId(String chasseId) {
		this.chasseId = chasseId;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLicencePlate() {
		return licencePlate;
	}
	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}
	public Date getAge() {
		return age;
	}
	public void setAge(Date age) {
		this.age = age;
	}
	public String getJMBG() {
		return JMBG;
	}
	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

}