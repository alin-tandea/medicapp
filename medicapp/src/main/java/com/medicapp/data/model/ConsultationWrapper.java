package com.medicapp.data.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConsultationWrapper {
	private String date;
	private int hour;
	private int minute;
	private int idStaff;
	private int idPatient;
	
	
	
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}

	public ConsultationWrapper(String date, int hour, int minute, int idStaff, int idPatient) {
		super();
		this.date = date;
		this.hour = hour;
		this.minute = minute;
		this.idStaff = idStaff;
		this.idPatient = idPatient;
	}
	public ConsultationWrapper() {
		super();
	}
	@Override
	public String toString() {
		return "ConsultationWrapper [date=" + date + ", hour=" + hour + ", minute=" + minute + ", idStaff=" + idStaff
				+ ", idPatient=" + idPatient + "]";
	}
	
	
	
}
