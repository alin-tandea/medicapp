package com.medicapp;

import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.Staff;
import com.medicapp.service.ConsultationService;
import com.medicapp.service.StaffService;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("hour  = " + date.toInstant().atZone(ZoneId.systemDefault()).getHour());
		System.out.println("minute  = " + date.toInstant().atZone(ZoneId.systemDefault()).getMinute());
		System.out.println("day  = " + date.toInstant().atZone(ZoneId.systemDefault()).getDayOfMonth());
		ConsultationService.addConsultation(2017, 2, 10, 14, 30, 1, 6);
		/*Staff s = new Staff();
		s.setName("test");
		s.setPassword("test");
		s.setUsername("test");
		s.setWorkdays("1234500");
		s.setRole(1);
		StaffService.addStaff(s);*/
	}

}
