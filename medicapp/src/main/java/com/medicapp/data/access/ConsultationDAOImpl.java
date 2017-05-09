package com.medicapp.data.access;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.medicapp.data.HibernateUtil;
import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.Patient;
import com.medicapp.data.model.Staff;

public class ConsultationDAOImpl implements ConsultationDAO{

	private SessionFactory sessionFactory;
	
	
	public ConsultationDAOImpl() {
		super();
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void addConsultation(Date datestart, int idpatient, int idstaff) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Consultation c = new Consultation();
		c.setDatestart(datestart);
		Patient p = (Patient)session.get(Patient.class, idpatient);
		Staff s = session.get(Staff.class, idstaff);
		c.setPatient(p);
		c.setPatientName(p.getName());
		c.setStaff(s);
		p.getConsultations().add(c);
		s.getConsultations().add(c);
		System.out.println(p.getIdpatient());
		System.out.println(s.getIdstaff());
		session.save(c);
		session.save(p);
		session.save(s);
		tx.commit();
		
	}

	@Override
	public void completeConsultation(int idconsultation , String reason) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Consultation c = (Consultation)session.get(Consultation.class, idconsultation);
		Date d = new Date();
		c.setDateend(d);
		c.setReason(reason);
		c.getPatient().getConsultations().stream().filter(cons ->cons.getIdconsultation() == idconsultation).findFirst().get().setDateend(d);
		c.getPatient().getConsultations().stream().filter(cons ->cons.getIdconsultation() == idconsultation).findFirst().get().setReason(reason);
		c.getStaff().getConsultations().stream().filter(cons ->cons.getIdconsultation() == idconsultation).findFirst().get().setDateend(d);
		c.getStaff().getConsultations().stream().filter(cons ->cons.getIdconsultation() == idconsultation).findFirst().get().setReason(reason);
		session.update(c);
		session.update(c.getPatient());
		session.update(c.getStaff());
		tx.commit();
		session.close();

	}

	@Override
	public Consultation getConsultation(int idconsultation) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Consultation c = (Consultation)session.get(Consultation.class, idconsultation);
		session.save(c);
		tx.commit();
		return c;
	}

	@Override
	public ArrayList<Consultation> getConsultations(int idpatient) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Patient p = (Patient)session.get(Patient.class, idpatient);
		tx.commit();
		return new ArrayList<Consultation>(p.getConsultations());
	}

	@Override
	public ArrayList<Consultation> getConsultationsMedic(int idstaff) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Staff s = session.get(Staff.class, idstaff);
		tx.commit();
		return new ArrayList<Consultation>(s.getConsultations());
	}
	

}
