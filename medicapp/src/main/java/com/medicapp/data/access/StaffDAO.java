package com.medicapp.data.access;

import java.util.ArrayList;

import com.medicapp.data.model.Staff;

public interface StaffDAO {
	void addStaff(String name  , String username , String password , int role );
	void updateStaff(int idstaff, String name  , String username , String password , int role );
	void deleteStaff(int idstaff);
	ArrayList<Staff> getAllStaff();
	int verifyLogIn(String username, String password);
	Staff getStaff(int idstaff);
}
