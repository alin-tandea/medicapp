package com.medicapp.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "knowndisease")
public class KnownDisease {

	@Id
	@GeneratedValue
	@Column(name = "idKnownDisease")
	private int idKnownDisease;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "patient_idpatient", nullable = false)
	private Patient patient;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "disease_iddisease", nullable = false)
	private Disease disease;

	public int getIdKnownDisease() {
		return idKnownDisease;
	}

	public void setIdKnownDisease(int idKnownDisease) {
		this.idKnownDisease = idKnownDisease;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public KnownDisease(int idKnownDisease, Patient patient, Disease disease) {
		super();
		this.idKnownDisease = idKnownDisease;
		this.patient = patient;
		this.disease = disease;
	}

	public KnownDisease() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "KnownDisease [idKnownDisease=" + idKnownDisease + "]";
	}

}
