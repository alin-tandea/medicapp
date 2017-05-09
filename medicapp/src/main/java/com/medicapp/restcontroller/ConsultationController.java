package com.medicapp.restcontroller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.medicapp.data.model.Consultation;
import com.medicapp.service.ConsultationService;

import java.util.List;

@Path("consultations")
public class ConsultationController {

	@Path("/{idstaff}/{day}")
	public List<Consultation> getTodayConsultations(@PathParam("idstaff") int idstaff, @PathParam("day") int day) {
		List<Consultation> consultations = ConsultationService.getTodayConsultationMedic(idstaff, day);
		return consultations;
	}

	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addConsultation() {
    	//System.out.println("\n\n\n\n\n" +params);
        //params = params.replace("\"" , "");
        //String[] splitParams = params.split("\\+");
        //System.out.println(splitParams);
		try {
			//ConsultationService.addConsultation(year, month, day, hour, minute, idpatient, idstaff);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(400).build();
		}
	}
}
