package com.medicapp.data.access;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.medicapp.data.HibernateUtil;
import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.Patient;
import com.medicapp.data.model.Staff;

public class ConsultationDAOImpl implements ConsultationDAO {

	private SessionFactory sessionFactory;

	public ConsultationDAOImpl() {
		super();
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public void addConsultation(Date datestart, int idpatient, int idstaff) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Consultation c = new Consultation();
		c.setDatestart(datestart);
		Patient p = (Patient) session.get(Patient.class, idpatient);
		Staff s = session.get(Staff.class, idstaff);
		c.setPatient(p);
		c.setStatus(0); // 0 - means not at hospital
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
		session.close();

	}

	@Override
	public void completeConsultation(int idconsultation, String reason) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Consultation c = (Consultation) session.get(Consultation.class, idconsultation);
		Date d = new Date();
		c.setDateend(d);
		c.setReason(reason);
		c.setStatus(2); // 2 - means completed
		session.update(c);
		tx.commit();
		session.close();

	}

	public void checkIn(int idconsultation) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Consultation c = (Consultation) session.get(Consultation.class, idconsultation);
		if (c.getStatus() == 0) {
			c.setStatus(1);
		} else {
			c.setStatus(0);
		}
		tx.commit();
		session.close();
	}

	@Override
	public Consultation getConsultation(int idconsultation) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Consultation c = (Consultation) session.get(Consultation.class, idconsultation);
		session.save(c);
		tx.commit();
		session.close();
		return c;
	}

	@Override
	public ArrayList<Consultation> getConsultations(int idpatient) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Patient p = (Patient) session.get(Patient.class, idpatient);
		tx.commit();
		//System.out.println(p);
		if (p != null) {
			ArrayList<Consultation> cons = new ArrayList<Consultation>(p.getConsultations());
			for (Consultation c : cons) {
				c.setPatientName(c.getPatient().getName());
			}
			session.close();
			return cons;
		} else {
			return null;
		}
	}

	@Override
	public ArrayList<Consultation> getConsultationsMedic(int idstaff) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Staff s = session.get(Staff.class, idstaff);
		System.out.println("get cons medic = " + s);
		tx.commit();
		if (s != null) {
			//System.out.println(s.getConsultations());
			List<Consultation> cons = new ArrayList<Consultation>(s.getConsultations());
			for (Consultation c : cons) {
				c.setPatientName(c.getPatient().getName());
			}
			session.close();
			return (ArrayList<Consultation>) cons;
		} else {
			return null;
		}
	}

	@Override
	public List<Consultation> getAllConsultations() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Consultation> cons = session.createQuery("select c from Consultation c").list();
		for (Consultation c : cons) {
			c.setPatientName(c.getPatient().getName());
		}
		tx.commit();
		session.close();
		return cons;
	}

}
