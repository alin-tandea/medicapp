package com.medicapp.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "workschedule")
public class WorkSchedule {
	
	@Id @GeneratedValue
	@Column(name = "idworkschedule")
	private int idWorkSchedule;
	
	@Column(name = "workday")
	private int workday;
	
	@Column(name = "starthour")
	private int startHour;
	
	@Column(name = "endhour")
	private int endHour;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_idstaff", nullable = false)
	private Staff staff;
	
	

	public WorkSchedule() {
		super();
	}

	public WorkSchedule(int idWorkSchedule, int workday, int startHour, int endHour, Staff staff) {
		super();
		this.idWorkSchedule = idWorkSchedule;
		this.workday = workday;
		this.startHour = startHour;
		this.endHour = endHour;
		this.staff = staff;
	}

	public int getIdWorkSchedule() {
		return idWorkSchedule;
	}

	public void setIdWorkSchedule(int idWorkSchedule) {
		this.idWorkSchedule = idWorkSchedule;
	}

	public int getWorkday() {
		return workday;
	}

	public void setWorkday(int workday) {
		this.workday = workday;
	}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "WorkSchedule [idWorkSchedule=" + idWorkSchedule + ", workday=" + workday + ", startHour=" + startHour
				+ ", endHour=" + endHour + ", staff=" + staff + "]";
	}
	
	
	
}
