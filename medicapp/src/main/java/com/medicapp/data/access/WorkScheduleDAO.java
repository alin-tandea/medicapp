package com.medicapp.data.access;

import java.util.List;

import com.medicapp.data.model.WorkSchedule;

public interface WorkScheduleDAO {
	List<WorkSchedule> getEntireSchedule(int idstaff);
	WorkSchedule getSpecificDaySchedule(int idstaff , int day);
	WorkSchedule getSchedule(int idworkschedule);
	void updateSchedule(int idWorkSchedule , int day , int startHour , int endHour);
	void addSchedule(int day , int startHour , int endHour ,int idstaff);
}
