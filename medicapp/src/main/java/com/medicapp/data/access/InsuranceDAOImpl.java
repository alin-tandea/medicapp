package com.medicapp.data.access;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.medicapp.data.HibernateUtil;
import com.medicapp.data.model.Insurance;
import com.medicapp.data.model.Patient;

public class InsuranceDAOImpl implements InsuranceDAO {

	private SessionFactory sessionFactory;

	public InsuranceDAOImpl() {
		super();
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public Insurance getInsurance(int idpatient) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Patient p = (Patient) session.get(Patient.class, idpatient);
		if (p != null) {
			Insurance i = p.getInsurance();
			tx.commit();
			session.close();
			return i;
		} else {
			tx.commit();
			session.close();
			return null;
		}
	}

	@Override
	public void updateInsurance(int id, String type, Date datestart, Date dateend) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Insurance i = (Insurance)session.get(Insurance.class, id);
		i.setType(type);
		i.setDatestart(datestart);
		i.setDateend(dateend);
		session.update(i);
		tx.commit();
		session.close();

	}

	@Override
	public void addInsurance(int idpatient , String type, Date datestart, Date dateend) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Insurance i = new Insurance();
		Patient p = (Patient)session.get(Patient.class, idpatient);
		i.setType(type);
		i.setDatestart(datestart);
		i.setDateend(dateend);
		p.setInsurance(i);
		session.save(i);
		session.save(p);
		tx.commit();
		session.close();
	}

}
