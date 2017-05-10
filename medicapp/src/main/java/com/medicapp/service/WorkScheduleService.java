package com.medicapp.service;

import java.util.List;

import com.medicapp.data.access.WorkScheduleDAO;
import com.medicapp.data.access.WorkScheduleDAOImpl;
import com.medicapp.data.model.WorkSchedule;

public class WorkScheduleService {

	private static WorkScheduleDAO w = new WorkScheduleDAOImpl();

	public static void addWorkSchedule(WorkSchedule schedule, int idstaff) {
		w.addSchedule(schedule.getWorkday(), schedule.getStartHour(), schedule.getEndHour(), idstaff);
	}
	
	public static List<WorkSchedule> getEntireSchedule(int idstaff){
		return w.getEntireSchedule(idstaff);
	}
}
