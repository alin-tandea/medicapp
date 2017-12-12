package com.medicapp.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "insurance")
public class Insurance {

	@Id
	@GeneratedValue
	@Column(name = "idinsurance")
	private int idinsurance;

	@Column(name = "type")
	private String type;

	@Column(name = "datestart")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datestart;

	@Column(name = "dateend")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateend;

	@OneToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@PrimaryKeyJoinColumn
	private Patient patient;

	public int getIdinsurance() {
		return idinsurance;
	}

	public void setIdinsurance(int idinsurance) {
		this.idinsurance = idinsurance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDatestart() {
		return datestart;
	}

	public void setDatestart(Date datestart) {
		this.datestart = datestart;
	}

	public Date getDateend() {
		return dateend;
	}

	public void setDateend(Date dateend) {
		this.dateend = dateend;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Insurance(int idinsurance, String type, Date datestart, Date dateend, Patient patient) {
		super();
		this.idinsurance = idinsurance;
		this.type = type;
		this.datestart = datestart;
		this.dateend = dateend;
		this.patient = patient;
	}

	public Insurance() {
		super();
	}

}
