package com.medicapp.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import com.medicapp.data.access.ConsultationDAO;
import com.medicapp.data.access.ConsultationDAOImpl;
import com.medicapp.data.model.Consultation;

public class ConsultationService {
	private static ConsultationDAO cd = new ConsultationDAOImpl();
	
	@SuppressWarnings("deprecation")
	public static void addConsultation(int year , int month ,int day , int hour , int minute , int idpatient , int idstaff){
		Date date = new Date();
		date.setMonth(month);
		date.setDate(day);
		date.setHours(hour);
		date.setMinutes(minute);
		date.setYear(year);
		cd.addConsultation(date, idpatient, idstaff);
	}
	
	public static void completeConsultation(int idconsultation , String reason){
		cd.completeConsultation(idconsultation, reason);
	}
		
	public static ArrayList<Consultation> getConsultations(int idpatient){
		return cd.getConsultations(idpatient);
	}
	
	public static ArrayList<Consultation> getTodayConsultationMedic(int idstaff , int day){
		return (ArrayList<Consultation>) getConsultationsMedic(idstaff).stream().filter(c -> c.getDatestart().toInstant().atZone(ZoneId.systemDefault()).getDayOfMonth() == day).collect(Collectors.toList());
	}
	
	public static ArrayList<Consultation> getConsultationsMedic(int idstaff){
		return cd.getConsultations(idstaff);
	}
	
	public static Consultation getConsultation(int idconsultation){
		return cd.getConsultation(idconsultation);
	}
}
