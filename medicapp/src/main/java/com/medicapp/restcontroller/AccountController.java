package com.medicapp.restcontroller;

import java.lang.reflect.Modifier;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import com.medicapp.data.model.Staff;
import com.medicapp.service.StaffService;

@Path("/accounts")
public class AccountController {

	private Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();

	@GET
	@Path("/all")
	public Response getAllAccounts() {
		return Response.status(200).entity(gson.toJson(StaffService.getAllStaff())).build();
	}

	@GET
	@Path("/{id}")
	public Response getAccount(@PathParam("id") int idstaff) {
		return Response.status(200).entity(gson.toJson(StaffService.getStaff(idstaff))).build();
	}

	@POST
	@Path("/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addAccount(Staff s) {
		try {
			StaffService.addStaff(s);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(400).build();
		}
	}

	@PUT
	@Path("/update/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response updateAccount(@PathParam("id") int idstaff, Staff s) {
		System.out.println(s);
		try {
			StaffService.updateStaff(idstaff, s);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(400).build();
		}
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteAccount(@PathParam("id") int idstaff){
		try{
			StaffService.deleteAccount(idstaff);
			return Response.ok().build();
		}catch(Exception e){
			return Response.status(400).build();
		}
	}

}
