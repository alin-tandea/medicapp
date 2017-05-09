package com.medicapp.data.model;

import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
	
	@Transient
	private String patientName;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "patient_idpatient", nullable = false)
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_idstaff", nullable = false)
	private Staff staff;

	


	public Consultation(int idconsultation, Date datestart, Date dateend, String reason, String patientName,
			Patient patient, Staff staff) {
		super();
		this.idconsultation = idconsultation;
		this.datestart = datestart;
		this.dateend = dateend;
		this.reason = reason;
		this.patientName = patientName;
		this.patient = patient;
		this.staff = staff;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Consultation() {
		// TODO Auto-generated constructor stub
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
