package com.medicapp.data.model;

import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement
@Entity
@Table(name = "consultation")
public class Consultation {
	
	@Id @GeneratedValue
	@Column(name = "idconsultation")
	@Expose
	private int idconsultation;
	
	@Column(name = "datestart")
	@Expose
	@Temporal(TemporalType.TIMESTAMP)
	private Date datestart;
	
	@Column(name = "dateend")
	@Expose
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateend;
	
	@Column(name = "reason")
	@Expose
	private String reason;
	
	@Column(name = "status")
	@Expose
	private int status;
	
	@Transient
	private String patientName;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@Expose(serialize = false)
	@JoinColumn(name = "patient_idpatient", nullable = false)
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Expose(serialize = false)
	@JoinColumn(name = "staff_idstaff", nullable = false)
	private Staff staff;

	


	

	public Consultation(int idconsultation, Date datestart, Date dateend, String reason, int status, String patientName,
			Patient patient, Staff staff) {
		super();
		this.idconsultation = idconsultation;
		this.datestart = datestart;
		this.dateend = dateend;
		this.reason = reason;
		this.status = status;
		this.patientName = patientName;
		this.patient = patient;
		this.staff = staff;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Consultation [idconsultation=" + idconsultation + ", datestart=" + datestart + ", dateend=" + dateend
				+ ", reason=" + reason + ", status=" + status + ", patientName=" + patientName + "]";
	}
	
	

}
