package com.medicapp.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "prescription")
public class Prescription {

	@Id
	@GeneratedValue
	@Column(name = "idprescription")
	private int idprescription;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "consultation_idconsultation", nullable = false)
	private Consultation consultation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "drug_iddrug", nullable = false)
	private Drug drug;

	public int getIdprescription() {
		return idprescription;
	}

	public void setIdprescription(int idprescription) {
		this.idprescription = idprescription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prescription(int idprescription, Date date, Consultation consultation, Drug drug) {
		super();
		this.idprescription = idprescription;
		this.date = date;
		this.consultation = consultation;
		this.drug = drug;
	}

}
