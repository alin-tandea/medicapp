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
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement
@Entity
@Table(name = "prescription")
public class Prescription {
	
	@Id @GeneratedValue
	@Expose
	@Column(name = "idprescription")
	private int idprescription;
	
	@Column(name = "date")
	@Expose
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	

	@ManyToOne(fetch = FetchType.LAZY )
	@Expose(serialize = false)
	@JoinColumn(name = "consultation_idconsultation", nullable = false)
	private Consultation consultation;
	
	@Expose(serialize = false)
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "prescpription")
	private Set<Drug> drugList = new HashSet<Drug>(0);

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

	public Set<Drug> getDrugList() {
		return drugList;
	}

	public void setDrugList(Set<Drug> drugList) {
		this.drugList = drugList;
	}

	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prescription(int idprescription, Date date, Consultation consultation, Set<Drug> drugList) {
		super();
		this.idprescription = idprescription;
		this.date = date;
		this.consultation = consultation;
		this.drugList = drugList;
	}
	
	
}
