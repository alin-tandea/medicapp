package com.medicapp.restcontroller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medicapp.data.model.Drug;
import com.medicapp.data.model.PrescriptWrap;
import com.medicapp.service.DrugService;

@Path("/drugs")
public class DrugController {
	
	private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	
	@GET
	@Path("/all")
	public Response getAllDrugs(){
		return Response.status(200).entity(gson.toJson(DrugService.getAllDrugs())).build();
	}
	
	@GET
	@Path("/{name}")
	public Response searchDrugs(@PathParam("name") String name){
		return Response.status(200).entity(gson.toJson(DrugService.searchDrugName(name))).build();
	}
	
	@POST
	@Path("/pdf/{idstaff}/{idconsult}")
	public Response generatePrescript(@PathParam("idstaff") int idstaff , @PathParam("idconsult") int idconsult , String drugs){

		Drug[] drugArray = gson.fromJson(drugs, Drug[].class);
		
		List<Drug> d = Arrays.asList(drugArray);
		DrugService.generatePrescript(d, idstaff, idconsult);
		return Response.status(200).build();

	}
	
	@GET
	@Path("/pdf")
	public Response getPdf(){
		ByteArrayOutputStream ba= DrugService.loadPdf();
		String pdfBase64String = 
				org.apache.commons.codec.binary.StringUtils.newStringUtf8(org.apache.
				commons.codec.binary.Base64.encodeBase64(ba.toByteArray()));
		return Response.status(200).entity(pdfBase64String).build();
	}
}
