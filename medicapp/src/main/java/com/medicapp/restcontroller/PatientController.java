package com.medicapp.restcontroller;


import java.lang.reflect.Modifier;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medicapp.data.model.Patient;
import com.medicapp.service.PatientService;

@Path("/patients")
public class PatientController {
	
	private Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
	
	@GET
	@Path("/all")
	public Response getPatients(){
		System.out.println("here");
		return Response.status(200).entity(gson.toJson(PatientService.getAllPatients())).build();
	}
	
	@GET
	@Path("/name/{searchParam}")
	public Response searchByName(@PathParam("searchParam") String name){
		return Response.status(200).entity(gson.toJson(PatientService.searchPatientByName(name))).build();
	}
	
	@GET
	@Path("/cnp/{searchParam}")
	public Response searchByCnp(@PathParam("searchParam") String name){
		return Response.status(200).entity(gson.toJson(PatientService.searchPatientByCnp(name))).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getPatient(@PathParam("id") int idpatient){
		return Response.status(200).entity(gson.toJson(PatientService.getPatient(idpatient))).build();
	}
	
	@POST
	@Path("/new")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
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
