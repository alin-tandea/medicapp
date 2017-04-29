package com.medicapp;

import com.medicapp.data.access.ConsultationDAO;
import com.medicapp.data.access.ConsultationDAOImpl;
import com.medicapp.data.access.PatientDAO;
import com.medicapp.data.access.PatientDAOImpl;
import com.medicapp.data.access.StaffDAO;
import com.medicapp.data.access.StaffDAOImpl;

import java.util.Date;
/**
 * Hello world!
 *
 */
@SuppressWarnings("unused")
public class App 
{
    public static void main( String[] args )
    {
    	Date d = new Date();
    	ConsultationDAO cd = new ConsultationDAOImpl();
    	/*PatientDAO pd  = new PatientDAOImpl();
    	StaffDAO sd = new StaffDAOImpl();
    	pd.addPatient("new", "12345", "1111111", d, "testADDR");
    	sd.addStaff("staff", "staff", "staff", 1, "1111100");*/
    	//Date d1 = new Date();
    	//cd.addConsultation(d1, 5, 6);
    	cd.completeConsultation(21, "test consult");
    }
}
