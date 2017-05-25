package com.medicapp.restcontroller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medicapp.data.model.ConsultCompleteWrapper;
import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.ConsultationComparator;
import com.medicapp.data.model.ConsultationWrapper;
import com.medicapp.data.model.Patient;
import com.medicapp.service.ConsultationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("consultations")
public class ConsultationController {

	Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	private ConsultationComparator comp = new ConsultationComparator();
	@SuppressWarnings("deprecation")
	@GET
	@Path("/date/current")
	public Response getTodayConsultation() {
		Date date = new Date();

		System.out.println(date.getYear() + 1900);
		
		List<Consultation> res = ConsultationService.getTodayConsultations(date.getDate(), date.getMonth(), date.getYear());
		res.sort(comp);
		return Response.status(200)
				.entity(gson.toJson(res))
				.build();
	}

	@GET
	@Path("/patient/{id}")
	public Response getPatientConsultations(@PathParam("id") int id){
		return Response.status(200).entity(gson.toJson(ConsultationService.getConsultations(id))).build();
	}
	
	@GET
	@Path("/date/{day}/{month}/{year}")
	public Response getTodayConsultation(@PathParam("day") int day, @PathParam("month") int month,
			@PathParam("year") int year) {
		List<Consultation> res = ConsultationService.getTodayConsultations(day, month, year);
		res.sort(comp);
		System.out.println(day + "/" + month + "/" + year);
		return Response.status(200).entity(gson.toJson(res))
				.build();
	}

	@GET
	@Path("/medic/{id}/{day}/{month}/{year}")
	public Response getMedicConsultation(@PathParam("day") int day, @PathParam("month") int month,
			@PathParam("year") int year, @PathParam("id") int id) {
		System.out.println(day + "/" + month + "/" + year);
		return Response.status(200)
				.entity(gson.toJson(ConsultationService.getTodayConsultationMedic(id, day, month, year))).build();
	}

	@SuppressWarnings("deprecation")
	@GET
	@Path("/medic/{id}")
	public Response getTodayMedicConsultation(@PathParam("id")int id){
		Date date = new Date();
		return Response.status(200).entity(gson.toJson(ConsultationService.getTodayConsultationMedic(id, date.getDate(),
				date.getMonth() +1, date.getYear()+1900))).build();
	}

	@PUT
	@Path("/medic/complete/{id}")
	public Response completeConsult(@PathParam("id")int id , ConsultCompleteWrapper cons){
		System.out.println(cons);
		ConsultationService.completeConsultation(id, cons.getObservations());
		return Response.ok().build();
	}
	
	@GET
	@Path("/checkin/{id}")
	public Response checkIn(@PathParam("id") int id) {
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
	
	@GET
	@Path("/patient/cons/{idconsultation}")
	public Response getPatient(@PathParam("idconsultation") int idconsultation){
		Patient p = ConsultationService.getPatient(idconsultation);
		Patient temp = new Patient();
		temp.setIdpatient(p.getIdpatient());
		temp.setName(p.getName());
		temp.setAddress(p.getAddress());
		temp.setBirthdate(p.getBirthdate());
		temp.setCnp(p.getCnp());
		temp.setIdcardNumber(p.getIdcardNumber());
		temp.setBloodtype(p.getBloodtype());
		System.out.println(gson.toJson(temp));
		return Response.status(200).entity(gson.toJson(temp)).build();
	}
}
