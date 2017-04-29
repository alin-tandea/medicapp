package com.medicapp.data.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "consultation")
public class Consultation {
	
	@Id @GeneratedValue
	@Column(name = "idconsultation")
	private int idconsultation;
	
	@Column(name = "datestart")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datestart;
	
	@Column(name = "dateend")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateend;
	
	@Column(name = "reason")
	private String reason;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpatient" , nullable = false)
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idstaff")
	private Staff staff;

	
	
	public Consultation(int idconsultation, Date datestart, Date dateend, String reason, Patient patient, Staff staff) {
		super();
		this.idconsultation = idconsultation;
		this.datestart = datestart;
		this.dateend = dateend;
		this.reason = reason;
		this.patient = patient;
		this.staff = staff;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public int getIdconsultation() {
		return idconsultation;
	}

	public void setIdconsultation(int idconsultation) {
		this.idconsultation = idconsultation;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
