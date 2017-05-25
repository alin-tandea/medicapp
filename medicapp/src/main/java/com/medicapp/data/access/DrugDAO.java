package com.medicapp.data.access;

import java.util.Date;
import java.util.List;

import com.medicapp.data.model.Drug;

public interface DrugDAO {
	List<Drug> getAllDrugsConsultation(int idconsultation);
	void addDrugOnPrescription(int idconsultation, int iddrug, Date date);
}
