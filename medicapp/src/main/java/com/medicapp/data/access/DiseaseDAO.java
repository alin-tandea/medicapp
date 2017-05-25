package com.medicapp.data.access;

import java.util.List;
import java.util.Set;

import com.medicapp.data.model.Disease;
import com.medicapp.data.model.KnownDisease;

public interface DiseaseDAO {
	Set<KnownDisease>getPatientDiseases(int idpatient);
	List<Disease> getAllDiseases();
	void addDisease(int idpatient , int iddisease);	
	void deleteDisease(int idpatient , int iddisease);
}
