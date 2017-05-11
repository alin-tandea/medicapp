package com.medicapp.restcontroller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medicapp.data.model.ConsultationWrapper;
import com.medicapp.service.ConsultationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("consultations")
public class ConsultationController {

	Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

	
	@SuppressWarnings("deprecation")
	@GET
	@Path("/date/current")
	public Response getTodayConsultation() {
		Date date = new Date();
		return Response.status(200).entity(gson.toJson(ConsultationService.getTodayConsultations(date.getDate()))).build();
	}
	
	@GET
	@Path("/date/{day}")
	public Response getTodayConsultation(@PathParam("day") int day) {
		return Response.status(200).entity(gson.toJson(ConsultationService.getTodayConsultations(day))).build();
	}

	@GET
	@Path("/checkin/{id}")
	public Response checkIn(@PathParam("id") int id){
		ConsultationService.checkIn(id);
		return Response.ok().build();
	}
	
	@SuppressWarnings("deprecation")
	@POST
	@Path("/add")
	public Response addConsultation(ConsultationWrapper c) {
		System.out.println(c.getDate());
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		try {
			date = df.parse(c.getDate());
		} catch (ParseException e1) {

			e1.printStackTrace();
		}
		date.setHours(c.getHour());
		date.setMinutes(c.getMinute());
		System.out.println(c);
		try {
			ConsultationService.addConsultation(date, c.getIdPatient(), c.getIdStaff());
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(400).build();
		}
	}
}
