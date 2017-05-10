package com.medicapp.service;

import java.util.ArrayList;

import com.medicapp.data.access.StaffDAO;
import com.medicapp.data.access.StaffDAOImpl;
import com.medicapp.data.model.Staff;

public class StaffService {
	private static StaffDAO sd = new  StaffDAOImpl();
	
	public static void addStaff(Staff s){
		if(validateInfo(s)){
			sd.addStaff(s.getName(), s.getUsername(), s.getPassword(), s.getRole());
		}else{
			throw new RuntimeException("Duplicate username");
		}
	}
	
	public static void updateStaff(Staff s){
		sd.addStaff(s.getName(), s.getUsername(), s.getPassword(), s.getRole());
	}
	
	public static ArrayList<Staff> getAllStaff(){
		return sd.getAllStaff();
	}
	
	public static Staff getStaff(int idstaff){
		return sd.getStaff(idstaff);
	}
	
	private static boolean validateInfo(Staff s){
		ArrayList<Staff> members = sd.getAllStaff();
		for(Staff staff : members){
			if(staff.getUsername().toLowerCase().equals(s.getUsername().toLowerCase())){
				return false;
			}
		}
		return true;
	}
}
