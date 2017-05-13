package com.medicapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.medicapp.data.access.StaffDAO;
import com.medicapp.data.access.StaffDAOImpl;
import com.medicapp.data.model.JwtUtil;
import com.medicapp.data.model.LogInfo;
import com.medicapp.data.model.Staff;


public class StaffService {
	private static StaffDAO sd = new  StaffDAOImpl();
	private static JwtUtil j = new JwtUtil();
	public static void addStaff(Staff s){
		if(validateInfo(s)){
			sd.addStaff(s.getName(), s.getUsername(), s.getPassword(), s.getRole());
		}else{
			throw new RuntimeException("Duplicate username");
		}
	}
	
	public static LogInfo verifyLogIn(String user , String pass){
		int userId = sd.verifyLogIn(user, pass);
		if (userId != -1) {
			Staff acc = sd.getStaff(userId);
			LogInfo log = new LogInfo(user ,j.generateToken(acc) , acc.getIdstaff() , acc.getRole());
			return log;
		}
		return null;
	}
	
	public static void updateRole(int idstaff , int role){
		Staff s = getStaff(idstaff);
		sd.updateStaff(idstaff, s.getName(), s.getUsername(), s.getPassword(), role);
	}
	
	public static void updateStaff(int idstaff ,Staff s){
		sd.updateStaff(idstaff, s.getName(), s.getUsername(), s.getPassword(), s.getRole());
	}
	
	public static void deleteAccount(int idstaff){
		sd.deleteStaff(idstaff);
	}
	
	public static ArrayList<Staff> getAllStaff(){
		return sd.getAllStaff();
	}
	
	public static List<Staff> searchByUsername(String username){
		return sd.getAllStaff().stream().filter(s -> s.getUsername().toLowerCase().contains(username)).collect(Collectors.toList());
	}
	
	public static List<Staff> searchByName(String name){
		return sd.getAllStaff().stream().filter(s -> s.getName().toLowerCase().contains(name)).collect(Collectors.toList());
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
