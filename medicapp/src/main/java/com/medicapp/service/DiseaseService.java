package com.medicapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.medicapp.data.access.DiseaseDAO;
import com.medicapp.data.access.DiseaseDAOImpl;
import com.medicapp.data.model.Disease;
import com.medicapp.data.model.KnownDisease;

public class DiseaseService {

	private static DiseaseDAO d = new DiseaseDAOImpl();

	public static List<Disease> getPatientDiseases(int idpatient) {
		Set<KnownDisease> res = d.getPatientDiseases(idpatient);
		List<Disease> diseases = new ArrayList<Disease>();
		for(KnownDisease k : res){
			diseases.add(k.getDisease());
		}
		
		return diseases;
	}
	
	public static List<Disease> getAllDiseases(){
		return d.getAllDiseases();
	}
	
	public static void addDisease(int idpatient , int iddisease){
		d.addDisease(idpatient, iddisease);
	}
}
