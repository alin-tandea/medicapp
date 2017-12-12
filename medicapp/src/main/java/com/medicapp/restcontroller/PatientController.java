package com.medicapp.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicapp.data.model.Patient;
import com.medicapp.service.PatientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/medicapp/patients")
public class PatientController {

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<Patient> getPatients() {
		return PatientService.getAllPatients();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/name/{searchParam}")
	public List<Patient> searchByName(@PathVariable String searchParam) {
		return PatientService.searchPatientByName(searchParam);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cnp/{searchParam}")
	public List<Patient> searchByCnp(@PathVariable String searchParam) {
		return PatientService.searchPatientByCnp(searchParam);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Patient getPatient(@PathVariable int id) {
		return PatientService.getPatient(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new")
	public void addPatient(@RequestBody Patient p) {
		System.out.println(p.toString());
		try {
			PatientService.addPatient(p);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public void updatePatient(@PathVariable int id, @RequestBody Patient p) {
		System.out.println(p.toString());
		try {
			PatientService.updatePatient(id, p);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
