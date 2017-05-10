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
		
		System.out.println(WorkScheduleService.getEntireSchedule(1));
	}

}
