package com.medicapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.medicapp.data.access.ConsultationDAO;
import com.medicapp.data.access.ConsultationDAOImpl;
import com.medicapp.data.access.WorkScheduleDAO;
import com.medicapp.data.access.WorkScheduleDAOImpl;
import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.WorkSchedule;

public class ConsultationService {
	private static ConsultationDAO cd = new ConsultationDAOImpl();
	private static WorkScheduleDAO ws = new WorkScheduleDAOImpl();

	@SuppressWarnings("deprecation")
	private static boolean validateConsultation(Date date, int idstaff) {
		int weekday = date.getDay();
		WorkSchedule schedule = ws.getSpecificDaySchedule(idstaff, weekday);
		System.out.println(schedule + " hours = " + date.getHours());
		if (schedule != null) {
			if (date.getHours() < schedule.getStartHour() || date.getHours() > schedule.getEndHour()) {
				return false;
			}
		} else {
			return false;
		}

		int dateDay = date.getDate();
		List<Consultation> todayConsultation = getTodayConsultationMedic(idstaff, dateDay);
		System.out.println(todayConsultation);

		if (todayConsultation != null) {
			for (Consultation cons : todayConsultation) {
				if ((cons.getDatestart().getHours() == date.getHours())
						&& (cons.getDatestart().getMinutes() == date.getMinutes())) {
					return false;
				}
			}
		}
		return true;
	}

	public static void checkIn(int idconsultation){
		cd.checkIn(idconsultation);
	}
	
	public static void addConsultation(Date date, int idpatient, int idstaff) {
		if (validateConsultation(date, idstaff)) {
			cd.addConsultation(date, idpatient, idstaff);
		} else {
			throw new RuntimeException("unavailable date");
		}
	}

	public static void completeConsultation(int idconsultation, String reason) {
		cd.completeConsultation(idconsultation, reason);
	}

	public static ArrayList<Consultation> getConsultations(int idpatient) {
		return cd.getConsultations(idpatient);
	}

	@SuppressWarnings("deprecation")
	public static ArrayList<Consultation> getTodayConsultations(int day) {
		return (ArrayList<Consultation>) cd.getAllConsultations().stream()
				.filter(c -> c.getDatestart().getDate() == day).collect(Collectors.toList());
	}

	@SuppressWarnings("deprecation")
	public static ArrayList<Consultation> getTodayConsultationMedic(int idstaff, int day) {
		if (getConsultationsMedic(idstaff) != null) {
			System.out.println(getConsultationsMedic(idstaff));
			return (ArrayList<Consultation>) getConsultationsMedic(idstaff).stream()
					.filter(c -> c.getDatestart().getDate() == day).collect(Collectors.toList());
		} else {
			return null;
		}
	}

	public static ArrayList<Consultation> getConsultationsMedic(int idstaff) {
		return cd.getConsultationsMedic(idstaff);
	}

	public static Consultation getConsultation(int idconsultation) {
		return cd.getConsultation(idconsultation);
	}
}
