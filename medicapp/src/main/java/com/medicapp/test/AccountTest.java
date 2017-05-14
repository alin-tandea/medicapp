package com.medicapp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.medicapp.data.access.StaffDAO;
import com.medicapp.data.access.StaffDAOImpl;
import com.medicapp.data.model.Staff;

public class AccountTest {
	
	StaffDAO s = new StaffDAOImpl();
	int numberOfAccounts;
	int newNumber;
	String name = "abcdefgh";
	String username = "abcdefgh";
	String password = "abcdefgh";
	int role = 1;
	
	
	String nameUpdate = "kasdnajda";
	String usernameUpdate = "daoksdoijid";
	String passwordUpdate = "dakjdkasjd";
	int roleUpdate = -1;
	
	
	@Test
	public void addTest(){

		
		numberOfAccounts = s.getAllStaff().size();
		
		int id = s.addStaff(name, username, password, role);
		
		newNumber = s.getAllStaff().size();
		
		if(numberOfAccounts == newNumber) fail("adding an account failed");
		
		Staff staff = s.getStaff(id);
		
		assertNotNull("acc should exist" , staff);
		
		s.deleteStaff(id);
		
		newNumber = s.getAllStaff().size();
		
		if(numberOfAccounts != newNumber) fail("failed to delete account");
		
	}
	
	@Test
	public void updateTest(){

		
		numberOfAccounts = s.getAllStaff().size();
		
		int id = s.addStaff(name, username, password, role);
		
		newNumber = s.getAllStaff().size();
		
		if(numberOfAccounts == newNumber) fail("adding an account failed");
		
		s.updateStaff(id, nameUpdate, usernameUpdate, passwordUpdate, roleUpdate);
		
		Staff staff = s.getStaff(id);
		
		assertNotNull("acc should exist" , staff);
		
		assertEquals(nameUpdate , s.getStaff(id).getName());
		assertEquals(usernameUpdate , s.getStaff(id).getUsername());
		assertEquals(passwordUpdate , s.getStaff(id).getPassword());
		assertEquals(roleUpdate , s.getStaff(id).getRole());
		
		s.deleteStaff(id);
		
		newNumber = s.getAllStaff().size();
		
		if(numberOfAccounts != newNumber) fail("failed to delete account");
		
	
	}
	
	@Test
	public void deleteTest(){
		numberOfAccounts = s.getAllStaff().size();
		
		int id = s.addStaff(name, username, password, role);
		
		newNumber = s.getAllStaff().size();
		
		if(numberOfAccounts == newNumber) fail("adding an account failed");
		
		Staff staff = s.getStaff(id);
		
		assertNotNull("acc should exist" , staff);
		
		s.deleteStaff(id);
		
		assertNull("should be null" , s.getStaff(id));
		
		newNumber = s.getAllStaff().size();
		
		if(numberOfAccounts != newNumber) fail("failed to delete account");	
	}
	
	@Test
	public void logInTest(){
		numberOfAccounts = s.getAllStaff().size();
		
		int id = s.addStaff(name, username, password, role);
		
		newNumber = s.getAllStaff().size();
		
		if(numberOfAccounts == newNumber) fail("adding an account failed");
		
		int logID = s.verifyLogIn(username, password);
		
		if(logID == -1) fail ("user should log in");
		
		logID = s.verifyLogIn(username,  passwordUpdate);
		
		if(logID != -1) fail ("login should fail");
		
		s.updateStaff(id, nameUpdate, usernameUpdate, passwordUpdate, roleUpdate);
		
		logID = s.verifyLogIn(usernameUpdate,  passwordUpdate);
		
		if(logID != -1) fail ("login should fail cuz of invalid role");
		
		s.deleteStaff(id);
		
		assertNull("should be null" , s.getStaff(id));
		
		newNumber = s.getAllStaff().size();
		
		if(numberOfAccounts != newNumber) fail("failed to delete account");	
		
	}
}
