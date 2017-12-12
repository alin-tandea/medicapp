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

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name = "bloodtest")
public class BloodTest {
	
	@Id @GeneratedValue
	@Column(name = "idbloodtest")
	private int idbloodtest;
	
	@Column(name = "hgb")
	private String hgb;
	
	@Column(name = "paletets")
	private String paletets;
	
	@Column(name = "vsh")
	private String vsh;
	
	@Column(name = "tsh")
	private String tsh;
	
	@Column(name = "mg")
	private String mg;

	@Column(name = "fe")
	private String fe;
	
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "consultation_idconsultation", nullable = false)
	@JsonIgnore
	private Consultation consultation;

	public int getIdbloodtest() {
		return idbloodtest;
	}

	public void setIdbloodtest(int idbloodtest) {
		this.idbloodtest = idbloodtest;
	}

	public String getHgb() {
		return hgb;
	}

	public void setHgb(String hgb) {
		this.hgb = hgb;
	}

	public String getPaletets() {
		return paletets;
	}

	public void setPaletets(String paletets) {
		this.paletets = paletets;
	}

	public String getVsh() {
		return vsh;
	}

	public void setVsh(String vsh) {
		this.vsh = vsh;
	}

	public String getTsh() {
		return tsh;
	}

	public void setTsh(String tsh) {
		this.tsh = tsh;
	}

	public String getMg() {
		return mg;
	}

	public void setMg(String mg) {
		this.mg = mg;
	}

	public String getFe() {
		return fe;
	}

	public void setFe(String fe) {
		this.fe = fe;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public BloodTest(int idbloodtest, String hgb, String paletets, String vsh, String tsh, String mg, String fe,
			Consultation consultation) {
		super();
		this.idbloodtest = idbloodtest;
		this.hgb = hgb;
		this.paletets = paletets;
		this.vsh = vsh;
		this.tsh = tsh;
		this.mg = mg;
		this.fe = fe;
		this.consultation = consultation;
	}

	public BloodTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BloodTest [idbloodtest=" + idbloodtest + ", hgb=" + hgb + ", paletets=" + paletets + ", vsh=" + vsh
				+ ", tsh=" + tsh + ", mg=" + mg + ", fe=" + fe + "]";
	}
	
	
	
}
