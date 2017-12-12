package com.medicapp.restcontroller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicapp.data.model.ConsultCompleteWrapper;
import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.ConsultationComparator;
import com.medicapp.data.model.ConsultationWrapper;
import com.medicapp.data.model.Patient;
import com.medicapp.service.ConsultationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/medicapp/consultations")
public class ConsultationController {

	private ConsultationComparator comp = new ConsultationComparator();

	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.GET, value = "/date/current")
	public List<Consultation> getTodayConsultation() {
		Date date = new Date();

		System.out.println(date.getYear() + 1900);

		List<Consultation> res = ConsultationService.getTodayConsultations(date.getDate(), date.getMonth(),
				date.getYear());
		res.sort(comp);
		return res;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/patient/{id}")
	public List<Consultation> getPatientConsultations(@PathVariable int id) {
		return ConsultationService.getConsultations(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/date/{day}/{month}/{year}")
	public List<Consultation> getTodayConsultation(@PathVariable int day, @PathVariable int month,
			@PathVariable int year) {
		List<Consultation> res = ConsultationService.getTodayConsultations(day, month, year);
		res.sort(comp);
		System.out.println(day + "/" + month + "/" + year);
		return res;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/medic/{id}/{day}/{month}/{year}")
	public List<Consultation> getMedicConsultation(@PathVariable int id, @PathVariable int day, @PathVariable int month,
			@PathVariable int year) {
		System.out.println(day + "/" + month + "/" + year);
		return ConsultationService.getTodayConsultationMedic(id, day, month, year);
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.GET, value = "/medic/{id}")
	public List<Consultation> getTodayMedicConsultation(@PathVariable int id) {
		Date date = new Date();
		return ConsultationService.getTodayConsultationMedic(id, date.getDate(), date.getMonth() + 1,
				date.getYear() + 1900);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/medic/complete/{id}")
	public void completeConsult(@PathVariable int id, @RequestBody ConsultCompleteWrapper cons) {
		System.out.println(cons);
		ConsultationService.completeConsultation(id, cons.getObservations());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/checkin/{id}")
	public void checkIn(@PathVariable int id) {
		ConsultationService.checkIn(id);
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public void addConsultation(@RequestBody ConsultationWrapper c) {
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
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/patient/cons/{idconsultation}")

	public Patient getPatient(@PathVariable int idconsultation) {
		Patient p = ConsultationService.getPatient(idconsultation);
		Patient temp = new Patient();
		temp.setIdpatient(p.getIdpatient());
		temp.setName(p.getName());
		temp.setAddress(p.getAddress());
		temp.setBirthdate(p.getBirthdate());
		temp.setCnp(p.getCnp());
		temp.setIdcardNumber(p.getIdcardNumber());
		temp.setBloodtype(p.getBloodtype());
		return temp;
	}
}
