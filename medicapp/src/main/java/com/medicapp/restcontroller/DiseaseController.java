package com.medicapp.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicapp.data.model.Disease;
import com.medicapp.service.DiseaseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/medicapp/disease")
public class DiseaseController {

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<Disease> getAllDiseases() {
		return DiseaseService.getAllDiseases();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/patient/{idpatient}")
	public List<Disease> getDiseasePatient(@PathVariable int idpatient) {
		List<Disease> dis = DiseaseService.getPatientDiseases(idpatient);

		return dis;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/add/{idpatient}/{iddisease}")
	public void addDisease(@PathVariable int idpatient, @PathVariable int iddisease) {
		DiseaseService.addDisease(idpatient, iddisease);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idpatient}/{iddisease}")
	public void deleteDisease(@PathVariable int idpatient, @PathVariable int iddisease) {
		DiseaseService.deleteDisease(idpatient, iddisease);
	}

}
