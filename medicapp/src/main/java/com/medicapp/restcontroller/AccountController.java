package com.medicapp.restcontroller;

import java.lang.reflect.Modifier;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medicapp.service.StaffService;

@Path("/accounts")
public class AccountController {
	
	private Gson gson = new GsonBuilder()
						.excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
	
	@GET
	@Path("/all")
	public Response getAllAccounts(){	
		return Response.status(200).entity(gson.toJson(StaffService.getAllStaff())).build();
	}
	
}
