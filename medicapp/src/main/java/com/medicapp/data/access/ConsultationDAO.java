package com.medicapp.data.access;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.Patient;

public interface ConsultationDAO {
	void addConsultation(Date datestart , int idpatient , int idstaff);
	void completeConsultation(int idconsultation , String reason);	
	Consultation getConsultation(int idconsultation);
	ArrayList<Consultation> getConsultations(int idpatient);
	ArrayList<Consultation> getConsultationsMedic(int idstaff);
	List<Consultation> getAllConsultations();
	void checkIn(int idconsultation);
	Patient getPatient(int idconsultation);
	
}
