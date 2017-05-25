package com.medicapp.data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
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
	
	@Expose(serialize = false)
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "drug")
	private Set<Prescription> prescriptions = new HashSet<Prescription>(0);
	

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


	public Drug(int iddrug, String name, String price, Set<Prescription> prescriptions) {
		super();
		this.iddrug = iddrug;
		this.name = name;
		this.price = price;
		this.prescriptions = prescriptions;
	}

	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Drug() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
