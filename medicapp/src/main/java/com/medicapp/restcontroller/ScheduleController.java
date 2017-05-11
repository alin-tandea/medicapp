package com.medicapp.restcontroller;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medicapp.data.model.WorkSchedule;
import com.medicapp.service.WorkScheduleService;

@Path("/schedule")
public class ScheduleController {
	
	Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	
	@GET
	@Path("/medic/{id}")
	public Response getMedicSchedule(@PathParam("id") int idstaff){
		return Response.status(200).entity(gson.toJson(WorkScheduleService.getEntireSchedule(idstaff))).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getSchedule(@PathParam("id")int id){
		return Response.status(200).entity(gson.toJson(WorkScheduleService.getSchedule(id))).build();
	}
	
	@PUT
	@Path("/update")
	public Response updateSchedule(WorkSchedule w){
		System.out.println(w);
		try{
			WorkScheduleService.updateWorkSchedule(w);
			return Response.status(200).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(400).build();
		}
	}
	
	@POST
	@Path("/new/{id}")
	public Response addSchedule(@PathParam("id") int idstaff , WorkSchedule w){
		try{
			WorkScheduleService.addWorkSchedule(w, idstaff);
			return Response.ok().build();
		}catch(Exception e){
			return Response.status(400).build();
		}
	}
}
