package com.medicapp.service;

import java.util.ArrayList;

import com.medicapp.data.access.ConsultationDAO;
import com.medicapp.data.access.ConsultationDAOImpl;
import com.medicapp.data.model.Consultation;

public class ConsultationService {
	private static ConsultationDAO cd = new ConsultationDAOImpl();
	
	public static void addConsultation(Consultation c , int idpatient , int idstaff){
		cd.addConsultation(c.getDatestart(), idpatient, idstaff);
	}
	
	public static void completeConsultation(int idconsultation , String reason){
		cd.completeConsultation(idconsultation, reason);
	}
	
	public static ArrayList<Consultation> getConsultations(int idpatient){
		return cd.getConsultations(idpatient);
	}
	
	public static ArrayList<Consultation> getConsultationsMedic(int idstaff){
		return cd.getConsultations(idstaff);
	}
	
	public static Consultation getConsultation(int idconsultation){
		return cd.getConsultation(idconsultation);
	}
}
