package com.medicapp.restcontroller;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;


import com.medicapp.data.model.Patient;
import com.medicapp.service.PatientService;



@Path("/patients")
public class PatientController {

	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
	public List<Patient> getPatients(){
		List<Patient> patients =  PatientService.getAllPatients();
		//GenericEntity<List<Patient>> list = new GenericEntity<List<Patient>>(patients){};
		return patients;
	}
}
