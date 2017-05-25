package com.medicapp.service;

import com.medicapp.data.access.BloodTestDAO;
import com.medicapp.data.access.BloodTestDAOImpl;
import com.medicapp.data.model.BloodTest;

public class BloodTestService {

	private static BloodTestDAO bd = new BloodTestDAOImpl();

	public static void addBloodTest(int idcons, BloodTest b) {
		bd.addTest(idcons, b.getHgb(), b.getPaletets(), b.getVsh(), b.getTsh(), b.getMg(), b.getFe());
	}

	public static BloodTest getTest(int idcons) {
		return bd.getTest(idcons);
	}
}
