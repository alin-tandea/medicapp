package com.medicapp.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicapp.data.model.LogInfo;
import com.medicapp.data.model.Staff;
import com.medicapp.service.StaffService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/medicapp/accounts")
public class AccountController {

	@Autowired
	StaffService staffService;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<Staff> getAllAccounts() {
		return staffService.getAllStaff();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Staff getAccount(@PathVariable int id) {
		return staffService.getStaff(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/search/{username}")
	public List<Staff> searchByUsername(@PathVariable String username) {
		return staffService.searchByUsername(username);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/searchname/{name}")
	public List<Staff> searchByName(@PathVariable String name) {
		System.out.println(name);
		return staffService.searchByName(name);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/disable/{id}")
	public void disableAccount(@PathVariable int idstaff) {
		staffService.updateRole(idstaff, -1);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/enable/{id}")
	public void enableAccount(@PathVariable int idstaff) {
		staffService.updateRole(idstaff, 1);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/login/{username}+{password}")
	public LogInfo logIn(@PathVariable String username) {
		// credentials = credentials.replace("\"", "");
		// System.out.println(credentials);
		// String[] splitParams = credentials.split("\\+");
		// System.out.println(splitParams);
		// String username = splitParams[0];
		String password = "123456";
		System.out.println(username + password);
		LogInfo info = staffService.verifyLogIn(username, password);
		if (info == null) {
			throw new RuntimeException("invalid login");
		} else {
			return info;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new")
	public void addAccount(@RequestBody Staff s) {
		try {
			staffService.addStaff(s);
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public void updateAccount(@PathVariable int id, @RequestBody Staff s) {
		System.out.println(s);
		try {
			staffService.updateStaff(id, s);
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public void deleteAccount(@PathVariable int id) {
		try {
			staffService.deleteAccount(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
