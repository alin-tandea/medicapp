package com.medicapp.restcontroller;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.medicapp.data.model.Patient;
import com.medicapp.service.PatientService;

@Path("/patients")
public class PatientController {
	
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
	public List<Patient> getPatients(){
		List<Patient> patients =  PatientService.getAllPatients();
		return patients;
	}
	
	@GET
	@Path("/name/{searchParam}")
    @Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.TEXT_PLAIN})
	public List<Patient> searchByName(@PathParam("searchParam") String name){
		return PatientService.searchPatientByName(name);
	}
	
	@GET
	@Path("/cnp/{searchParam}")
    @Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.TEXT_PLAIN})
	public List<Patient> searchByCnp(@PathParam("searchParam") String name){
		return PatientService.searchPatientByCnp(name);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Patient getPatient(@PathParam("id") int idpatient){
		return PatientService.getPatient(idpatient);
	}
	
	@POST
	@Path("/new")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addPatient(Patient p){
		System.out.println(p.toString());
		try{
			PatientService.addPatient(p);
			return Response.ok().build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(400).build();
		}
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response updatePatient(@PathParam("id") int idpatient , Patient p){
		System.out.println(p.toString());
		try{
			PatientService.updatePatient(idpatient, p);
			return Response.ok().build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(400).build();
		}
	}
}
