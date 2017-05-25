package com.medicapp.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medicapp.data.model.Disease;
import com.medicapp.service.DiseaseService;

@Path("/disease")
public class DiseaseController {
	private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

	@GET
	@Path("/all")
	public Response getAllDiseases(){
		return Response.status(200).entity(gson.toJson(DiseaseService.getAllDiseases())).build();
	}
	
	@GET
	@Path("/patient/{idpatient}")
	public Response getDiseasePatient(@PathParam("idpatient") int idpatient){
		List<Disease> dis =  DiseaseService.getPatientDiseases(idpatient);
		
		return Response.status(200).entity(gson.toJson(dis)).build();
	}
	
	@GET
	@Path("/add/{idpatient}/{iddisease}")
	public Response addDisease(@PathParam("idpatient") int idpatient,@PathParam("iddisease") int iddisease){
		DiseaseService.addDisease(idpatient, iddisease);
		return Response.status(200).build();
	}
	
	@DELETE
	@Path("/delete/{idpatient}/{iddisease}")
	public Response deleteDisease(@PathParam("idpatient") int idpatient,@PathParam("iddisease") int iddisease){
		DiseaseService.deleteDisease(idpatient, iddisease);
		return Response.status(200).build();
	}
	
	
}
