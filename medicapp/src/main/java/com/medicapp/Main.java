package com.medicapp;

import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.Staff;
import com.medicapp.data.model.WorkSchedule;
import com.medicapp.service.ConsultationService;
import com.medicapp.service.StaffService;
import com.medicapp.service.WorkScheduleService;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		
		Staff s = new Staff();
		s.setName("name");
		s.setUsername("name");
		s.setPassword("test");
		s.setRole(1);
		StaffService.addStaff(s);
		
		WorkSchedule w = new WorkSchedule();
		w.setWorkday(1);
		w.setStartHour(2);
		w.setEndHour(3);
		WorkScheduleService.addWorkSchedule(w, 1);
	}

}
