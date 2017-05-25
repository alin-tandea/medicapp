package com.medicapp.data.access;

import java.util.Date;

import com.medicapp.data.model.Insurance;

public interface InsuranceDAO {
	Insurance getInsurance(int idpatient);
	void updateInsurance(int id , String type , Date datestart , Date dateend);
	void addInsurance(int idpatient , String type , Date datestart , Date dateend);
}
