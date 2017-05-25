package com.medicapp.restcontroller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medicapp.data.model.BloodTest;
import com.medicapp.service.BloodTestService;

@Path("/btest")
public class BloodTestController {

	Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	
	@POST
	@Path("/new/{idcons}")
	public Response addBloodTest(@PathParam("idcons") int idcons , String  str){
		System.out.println(str);
		BloodTest b = gson.fromJson(str, BloodTest.class);
		BloodTestService.addBloodTest(idcons, b);
		return Response.status(200).build();
	}
	
	@GET
	@Path("/{idcons}")
	public Response getBloodTest(@PathParam("idcons") int idcons){
		return Response.status(200).entity(gson.toJson(BloodTestService.getTest(idcons))).build();
	}
}
