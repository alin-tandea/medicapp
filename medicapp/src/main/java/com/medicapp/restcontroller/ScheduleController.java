package com.medicapp.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicapp.data.model.WorkSchedule;
import com.medicapp.service.WorkScheduleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/medicapp/schedule")
public class ScheduleController {

	@RequestMapping(method = RequestMethod.GET, value = "/medic/{idstaff}")
	public List<WorkSchedule> getMedicSchedule(@PathVariable int idstaff) {
		return WorkScheduleService.getEntireSchedule(idstaff);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public WorkSchedule getSchedule(@PathVariable int id) {
		return WorkScheduleService.getSchedule(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/medic/{id}/{day}/{month}/{year}")
	public WorkSchedule getMedicScheduleDay(@PathVariable int id, @PathVariable int day, @PathVariable int month,
			@PathVariable int year) {
		System.out.println(day + "/" + month + "/" + year);
		return WorkScheduleService.getScheduleDay(id, day, month, year);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public void updateSchedule(@RequestBody WorkSchedule w) {
		System.out.println(w);
		try {
			WorkScheduleService.updateWorkSchedule(w);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new/{id}")
	public void addSchedule(@PathVariable int idstaff, @RequestBody WorkSchedule w) {
		try {
			WorkScheduleService.addWorkSchedule(w, idstaff);
		} catch (Exception e) {
			throw e;
		}
	}
}
