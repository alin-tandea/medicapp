package com.medicapp.data.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {
	
	@Id @GeneratedValue
	@Column(name = "idstaff")
	private int idstaff;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private int role; // 0 - admin , 1 - medic , 2 - secretary
	
	@Column(name = "workdays")
	private String workdays;

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "staff")
	private Set<Consultation> consultations;
	
	
	
	public Staff(int idstaff, String name, String username, String password, int role, String workdays,
			Set<Consultation> consultations) {
		super();
		this.idstaff = idstaff;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.workdays = workdays;
		this.consultations = consultations;
	}
	public Staff() {
	}
	public Set<Consultation> getConsultations() {
		return consultations;
	}
	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}
	public int getIdstaff() {
		return idstaff;
	}
	public void setIdstaff(int idstaff) {
		this.idstaff = idstaff;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getWorkdays() {
		return workdays;
	}
	public void setWorkdays(String workdays) {
		this.workdays = workdays;
	}

	
}
