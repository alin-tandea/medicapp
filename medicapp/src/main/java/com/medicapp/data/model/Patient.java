package com.medicapp.data.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue
	@Column(name = "idpatient")
	private int idpatient;

	@Column(name = "name")
	private String name;

	@Column(name = "idcardnumber")
	private String idcardNumber;

	@Column(name = "cnp")
	private String cnp;

	@Column(name = "birthdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthdate;

	@Column(name = "address")
	private String address;

	@Column(name = "bloodtype")
	private String bloodtype;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Consultation> consultations = new HashSet<Consultation>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<KnownDisease> knownDiseases = new HashSet<KnownDisease>(0);

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "patient", cascade = CascadeType.ALL)
	@JsonIgnore
	private Insurance insurance;

	public Patient(int idpatient, String name, String idcardNumber, String cnp, Date birthdate, String address,
			String bloodtype, Set<Consultation> consultations, Set<KnownDisease> knownDiseases, Insurance insurance) {
		super();
		this.idpatient = idpatient;
		this.name = name;
		this.idcardNumber = idcardNumber;
		this.cnp = cnp;
		this.birthdate = birthdate;
		this.address = address;
		this.bloodtype = bloodtype;
		this.consultations = consultations;
		this.knownDiseases = knownDiseases;
		this.insurance = insurance;
	}

	public String getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}

	public Set<KnownDisease> getKnownDiseases() {
		return knownDiseases;
	}

	public void setKnownDiseases(Set<KnownDisease> knownDiseases) {
		this.knownDiseases = knownDiseases;
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Set<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}

	public int getIdpatient() {
		return idpatient;
	}

	public void setIdpatient(int idpatient) {
		this.idpatient = idpatient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcardNumber() {
		return idcardNumber;
	}

	public void setIdcardNumber(String idcardNumber) {
		this.idcardNumber = idcardNumber;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [idpatient=" + idpatient + ", name=" + name + ", idcardNumber=" + idcardNumber + ", cnp=" + cnp
				+ ", birthdate=" + birthdate + ", address=" + address + ", bloodtype=" + bloodtype + "]";
	}

}
