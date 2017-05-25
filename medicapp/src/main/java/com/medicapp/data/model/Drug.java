package com.medicapp.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement
@Entity
@Table(name = "drug")
public class Drug {
	
	@Id @GeneratedValue
	@Expose
	@Column(name = "iddrug")
	private int iddrug;
	
	@Column(name = "name")
	@Expose
	private String name;
	
	@Column(name = "price")
	@Expose
	private String price;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@Expose(serialize = false)
	@JoinColumn(name = "prescription_idprescription", nullable = false)
	private Prescription prescription;

	public int getIddrug() {
		return iddrug;
	}

	public void setIddrug(int iddrug) {
		this.iddrug = iddrug;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public Drug(int iddrug, String name, String price, Prescription prescription) {
		super();
		this.iddrug = iddrug;
		this.name = name;
		this.price = price;
		this.prescription = prescription;
	}

	public Drug() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
