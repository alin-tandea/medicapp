package com.medicapp.data.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name = "consultation")
public class Consultation {

	@Id
	@GeneratedValue
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

	@Column(name = "status")
	private int status;

	@Transient
	private String patientName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "patient_idpatient", nullable = false)
	private Patient patient;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "staff_idstaff", nullable = false)
	private Staff staff;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "consultation")
	@JsonIgnore
	private Set<Prescription> prescriptions = new HashSet<Prescription>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "consultation")
	@JsonIgnore
	private Set<BloodTest> tests = new HashSet<BloodTest>(0);

	public Consultation(int idconsultation, Date datestart, Date dateend, String reason, int status, String patientName,
			Patient patient, Staff staff, Set<Prescription> prescriptions, Set<BloodTest> tests) {
		super();
		this.idconsultation = idconsultation;
		this.datestart = datestart;
		this.dateend = dateend;
		this.reason = reason;
		this.status = status;
		this.patientName = patientName;
		this.patient = patient;
		this.staff = staff;
		this.prescriptions = prescriptions;
		this.tests = tests;
	}

	public Set<BloodTest> getTests() {
		return tests;
	}

	public void setTests(Set<BloodTest> tests) {
		this.tests = tests;
	}

	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
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
