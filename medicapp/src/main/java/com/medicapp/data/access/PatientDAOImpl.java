package com.medicapp.data.access;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.medicapp.data.HibernateUtil;
import com.medicapp.data.model.Patient;


public class PatientDAOImpl implements PatientDAO{

	private SessionFactory sessionFactory;
	
	
	public PatientDAOImpl() {
		super();
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	public void addPatient(String name, String idcardNumber, String cnp, Date birthdate, String address) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Patient p = new Patient();
		p.setName(name);
		p.setIdcardNumber(idcardNumber);
		p.setCnp(cnp);
		p.setBirthdate(birthdate);
		p.setAddress(address);
		session.save(p);
		tx.commit();
		session.close();
		
	}

	public void updatePatient(int idpatient, String name, String idcardNumber, String cnp, Date birthdate,
			String address) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Patient p = (Patient)session.get(Patient.class, idpatient);
		p.setName(name);
		p.setIdcardNumber(idcardNumber);
		p.setCnp(cnp);
		p.setBirthdate(birthdate);
		p.setAddress(address);
		session.update(p);
		tx.commit();
		session.close();

		
	}

	public ArrayList<Patient> getAllPatients() {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <Patient> patients = session.createQuery("select p from Patient p").list();
		tx.commit();
		return (ArrayList<Patient>) patients;
	}

	public ArrayList<Patient> searchPatientByName(String name) {
		return (ArrayList<Patient>) getAllPatients().stream().filter(p -> p.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
	}

	public ArrayList<Patient> searchPatientByCnp(String cnp) {
		return (ArrayList<Patient>) getAllPatients().stream().filter(p -> p.getCnp().toLowerCase().contains(cnp.toLowerCase())).collect(Collectors.toList());
	}

	public Patient getPatient(int idpatient) {
		return getAllPatients().stream().filter(p -> p.getIdpatient() == idpatient).findFirst().get();
	}

}
