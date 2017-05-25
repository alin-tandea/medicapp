package com.medicapp.service;

import java.util.Date;

import com.medicapp.data.access.DrugDAO;
import com.medicapp.data.access.DrugDAOImpl;

public class DrugService {

	private static DrugDAO d = new DrugDAOImpl();
	
	public static void addDrugOnPrescription(int idconsultation , int iddrug){
		Date date = new Date();
		d.addDrugOnPrescription(idconsultation, iddrug, date);
	}
}
