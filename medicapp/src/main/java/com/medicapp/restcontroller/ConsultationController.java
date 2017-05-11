package com.medicapp.restcontroller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.ConsultationWrapper;
import com.medicapp.service.ConsultationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("consultations")
public class ConsultationController {

	Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	
	@GET
	@Path("/{idstaff}/{day}")
	public List<Consultation> getTodayConsultations(@PathParam("idstaff") int idstaff, @PathParam("day") int day) {
		List<Consultation> consultations = ConsultationService.getTodayConsultationMedic(idstaff, day);
		return consultations;
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
