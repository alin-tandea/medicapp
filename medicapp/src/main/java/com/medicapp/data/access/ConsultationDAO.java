package com.medicapp.data.access;

import java.util.ArrayList;
import java.util.Date;

import com.medicapp.data.model.Consultation;

public interface ConsultationDAO {
	void addConsultation(Date datestart , int idpatient , int idstaff);
	void completeConsultation(int idconsultation , String reason);	
	Consultation getConsultation(int idconsultation);
	ArrayList<Consultation> getConsultations(int idpatient);
	ArrayList<Consultation> getConsultationsMedic(int idstaff);
	
}
