package com.medicapp.restcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicapp.data.model.BloodTest;
import com.medicapp.service.BloodTestService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/medicapp/btest")
public class BloodTestController {

	@RequestMapping(method = RequestMethod.POST, value = "/new/{idcons}")
	public void addBloodTest(@PathVariable int idcons, @RequestBody BloodTest b) {
		BloodTestService.addBloodTest(idcons, b);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idcons}")
	public BloodTest getBloodTest(@PathVariable int idcons) {
		return BloodTestService.getTest(idcons);
	}
}
