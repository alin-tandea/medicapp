package com.medicapp.data.model;

import java.util.Comparator;
import java.util.Date;

public class ConsultationComparator implements Comparator<Consultation> {

	@SuppressWarnings("deprecation")
	@Override
	public int compare(Consultation c1, Consultation c2) {
		Date date1 = c1.getDatestart();
		Date date2 = c2.getDatestart();

		if (date1.getHours() > date2.getHours()) {
			return 1;
		} else if (date1.getHours() == date2.getHours()) {
			return 0;
		} else {
			return -1;
		}
	}

}
