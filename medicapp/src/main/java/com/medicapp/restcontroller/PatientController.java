package com.medicapp.restcontroller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medicapp.data.model.Patient;
import com.medicapp.service.PatientService;



@Path("/patients")
public class PatientController {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getPatients(){
		for(Patient patient : PatientService.getAllPatients()){
			System.out.println(patient.getName());
		}
		return Response.ok("abc").build();
	}
}
