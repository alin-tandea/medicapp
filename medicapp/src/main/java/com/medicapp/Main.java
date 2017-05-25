package com.medicapp;

import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

import com.medicapp.data.access.ConsultationDAO;
import com.medicapp.data.access.ConsultationDAOImpl;
import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.Patient;
import com.medicapp.data.model.Staff;
import com.medicapp.data.model.WorkSchedule;
import com.medicapp.service.ConsultationService;
import com.medicapp.service.DiseaseService;
import com.medicapp.service.DrugService;
import com.medicapp.service.PatientService;
import com.medicapp.service.StaffService;
import com.medicapp.service.WorkScheduleService;

@SuppressWarnings("unused")
public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		/*Patient p = new Patient();
		p.setName("test");
		p.setCnp("1111111111111");
		
		Staff s = new Staff();
		
		s.setRole(0);
		s.setName("staff");
		s.setUsername("test");
		s.setPassword("1234");
		
		PatientService.addPatient(p);
		StaffService.addStaff(s);*/
		
		//Date d = new Date();
		//d.setDate(28);
		
		//ConsultationService.addConsultation(d, 1, 2);
		
		DrugService.addDrugOnPrescription(3, 1);
	}

}
