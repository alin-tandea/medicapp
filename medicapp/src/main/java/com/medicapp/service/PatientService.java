package com.medicapp.service;

import java.util.ArrayList;

import com.medicapp.data.access.PatientDAO;
import com.medicapp.data.access.PatientDAOImpl;
import com.medicapp.data.model.Patient;

public class PatientService {

	private static PatientDAO pd = new PatientDAOImpl();

	
	public static ArrayList<Patient> getAllPatients(){
		return pd.getAllPatients();
	}
	
	public static ArrayList<Patient> searchPatientByName(String name){
		return pd.searchPatientByName(name);
	}
	
	public static ArrayList<Patient> searchPatientByCnp(String cnp){
		return pd.searchPatientByCnp(cnp);
	}
	
	public static Patient getPatient(int idpatient){
		return pd.getPatient(idpatient);
	}
	
	public static void addPatient(Patient p) {
		if (validateAddInfo(p)) {
			pd.addPatient(p.getName(), p.getIdcardNumber(), p.getCnp(), p.getBirthdate(), p.getAddress());
		} else {
			throw new RuntimeException("Duplicate patient info");
		}
	}

	public static void updatePatient(int idpatient, Patient p) {
		if (validateUpdateInfo(idpatient , p)) {
			pd.updatePatient(idpatient, p.getName(), p.getIdcardNumber(), p.getCnp(), p.getBirthdate(), p.getAddress());
		}
	}

	private static boolean validateAddInfo(Patient p) {
		ArrayList<Patient> patients = pd.getAllPatients();
		for (Patient patient : patients) {
			if (patient.getCnp().equals(p.getCnp()) || patient.getIdcardNumber().equals(p.getIdcardNumber())) {
				return false;
			}
		}
		return true;
	}

	private static boolean validateUpdateInfo(int idpatient, Patient p) {
		ArrayList<Patient> patients = pd.getAllPatients();
		for (Patient patient : patients) {
			if ((patient.getCnp().equals(p.getCnp()) || patient.getIdcardNumber().equals(p.getIdcardNumber()))
					&& (patient.getIdpatient() != idpatient)) {
				return false;
			}
		}
		return true;
	}
}
