package com.medicapp.data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement
@Entity
@Table(name = "staff")
public class Staff {
	
	@Id @GeneratedValue
	@Expose
	@Column(name = "idstaff")
	private int idstaff;
	
	@Column(name = "name")
	@Expose
	private String name;
	
	@Column(name = "username")
	@Expose
	private String username;
	
	@Column(name = "password")
	@Expose
	private String password;
	
	@Column(name = "role")
	@Expose
	private int role; // 0 - admin , 1 - medic , 2 - secretary

	@Expose(serialize = false)
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,  mappedBy = "staff")
	private Set<WorkSchedule> workdays =  new HashSet<WorkSchedule>(0);

	@Expose(serialize = false)
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,  mappedBy = "staff")
	private Set<Consultation> consultations =  new HashSet<Consultation>(0);
	
	
	
	
	public Set<WorkSchedule> getWorkdays() {
		return workdays;
	}
	public void setWorkdays(Set<WorkSchedule> workdays) {
		this.workdays = workdays;
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
	@Override
	public String toString() {
		return "Staff [idstaff=" + idstaff + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", role=" + role;
	}


	
}
