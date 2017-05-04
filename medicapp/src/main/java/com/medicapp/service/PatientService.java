package com.medicapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.medicapp.data.access.PatientDAO;
import com.medicapp.data.access.PatientDAOImpl;
import com.medicapp.data.model.Patient;

public class PatientService {

	private static PatientDAO pd = new PatientDAOImpl();

	public static ArrayList<Patient> getAllPatients() {
		return pd.getAllPatients();
	}

	public static ArrayList<Patient> searchPatientByName(String name) {
		return pd.searchPatientByName(name);
	}

	public static ArrayList<Patient> searchPatientByCnp(String cnp) {
		return pd.searchPatientByCnp(cnp);
	}

	public static Patient getPatient(int idpatient) {
		return pd.getPatient(idpatient);
	}

	public static void addPatient(Patient p) {
		if (validateAddInfo(p)) {
			Date d = cnpParse(p.getCnp());
			pd.addPatient(p.getName(), p.getIdcardNumber(), p.getCnp(), d, p.getAddress());
		} else {
			throw new RuntimeException("Duplicate patient info");
		}
	}

	public static void updatePatient(int idpatient, Patient p) {
		if (validateUpdateInfo(idpatient, p)) {
			Date d = cnpParse(p.getCnp());
			pd.updatePatient(idpatient, p.getName(), p.getIdcardNumber(), p.getCnp(), d, p.getAddress());
		} else {
			throw new RuntimeException("Duplicate patient info");
		}
	}

	private static boolean validateAddInfo(Patient p) {
		ArrayList<Patient> patients = pd.getAllPatients();
		for (Patient patient : patients) {
			if (patient.getIdcardNumber() != null) {
				if (patient.getCnp().equals(p.getCnp()) || patient.getIdcardNumber().equals(p.getIdcardNumber())) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean validateUpdateInfo(int idpatient, Patient p) {
		ArrayList<Patient> patients = pd.getAllPatients();
		for (Patient patient : patients) {
			if (patient.getIdcardNumber() != null) {
				if ((patient.getCnp().equals(p.getCnp()) || patient.getIdcardNumber().equals(p.getIdcardNumber()))
						&& (patient.getIdpatient() != idpatient)) {
					return false;
				}
			}
		}
		return true;
	}

	public static Date cnpParse(String cnp) {
		StringBuilder sb = new StringBuilder();
		if (Integer.parseInt(cnp.substring(0, 1)) < 2) {
			sb.append("19" + cnp.substring(1, 3));
		} else {
			sb.append("20" + cnp.substring(1, 3));
		}
		sb.append('-');
		sb.append(cnp.substring(3, 5));
		sb.append('-');
		sb.append(cnp.substring(5, 7));
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date d = null;
		try {
			d = sd.parse(sb.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
}
