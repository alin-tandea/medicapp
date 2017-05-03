package com.medicapp.restcontroller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

import com.medicapp.data.model.Patient;
import com.medicapp.service.PatientService;

@Path("/patient")
public class PatientController {
	
	@GET
	public List<Patient> getPatients(){
		return PatientService.getAllPatients();
	}
}
