package com.medicapp.data.access;

import java.util.ArrayList;
import java.util.Date;

import com.medicapp.data.model.Patient;

public interface PatientDAO {
	void addPatient(String name , String idcardNumber , String cnp , Date birthdate , String address);
	void updatePatient(int idpatient , String name , String idcardNumber , String cnp , Date birthdate , String address);
	ArrayList<Patient> getAllPatients();
	ArrayList<Patient> searchPatientByName(String name);
	ArrayList<Patient> searchPatientByCnp(String name);
	Patient getPatient(int idpatient);
	
}
