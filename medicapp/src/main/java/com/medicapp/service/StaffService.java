package com.medicapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.medicapp.data.access.StaffDAO;
import com.medicapp.data.access.StaffDAOImpl;
import com.medicapp.data.model.JwtUtil;
import com.medicapp.data.model.LogInfo;
import com.medicapp.data.model.Staff;

@Service
public class StaffService {
	private StaffDAO sd = new StaffDAOImpl();
	private JwtUtil j = new JwtUtil();

	public void addStaff(Staff s) {
		if (validateInfo(s)) {
			sd.addStaff(s.getName(), s.getUsername(), s.getPassword(), s.getRole());
		} else {
			throw new RuntimeException("Duplicate username");
		}
	}

	public LogInfo verifyLogIn(String user, String pass) {
		int userId = sd.verifyLogIn(user, pass);
		if (userId != -1) {
			Staff acc = sd.getStaff(userId);
			LogInfo log = new LogInfo(user, j.generateToken(acc), acc.getIdstaff(), acc.getRole());
			return log;
		}
		return null;
	}

	public void updateRole(int idstaff, int role) {
		Staff s = getStaff(idstaff);
		sd.updateStaff(idstaff, s.getName(), s.getUsername(), s.getPassword(), role);
	}

	public void updateStaff(int idstaff, Staff s) {
		sd.updateStaff(idstaff, s.getName(), s.getUsername(), s.getPassword(), s.getRole());
	}

	public void deleteAccount(int idstaff) {
		sd.deleteStaff(idstaff);
	}

	public ArrayList<Staff> getAllStaff() {
		return sd.getAllStaff();
	}

	public List<Staff> searchByUsername(String username) {
		return sd.getAllStaff().stream().filter(s -> s.getUsername().toLowerCase().contains(username))
				.collect(Collectors.toList());
	}

	public List<Staff> searchByName(String name) {
		return sd.getAllStaff().stream().filter(s -> s.getName().toLowerCase().contains(name))
				.collect(Collectors.toList());
	}

	public Staff getStaff(int idstaff) {
		return sd.getStaff(idstaff);
	}

	private boolean validateInfo(Staff s) {
		ArrayList<Staff> members = sd.getAllStaff();
		for (Staff staff : members) {
			if (staff.getUsername().toLowerCase().equals(s.getUsername().toLowerCase())) {
				return false;
			}
		}
		return true;
	}
}
