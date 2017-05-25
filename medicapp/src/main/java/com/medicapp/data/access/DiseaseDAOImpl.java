package com.medicapp.data.access;


import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.medicapp.data.HibernateUtil;
import com.medicapp.data.model.Disease;
import com.medicapp.data.model.KnownDisease;
import com.medicapp.data.model.Patient;

public class DiseaseDAOImpl implements DiseaseDAO {

	private SessionFactory sessionFactory;

	public DiseaseDAOImpl() {
		super();
		this.sessionFactory = HibernateUtil.getSessionFactory();

	}

	@Override
	public Set<KnownDisease> getPatientDiseases(int idpatient) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Patient p = (Patient) session.get(Patient.class, idpatient);
		System.out.println(p.getKnownDiseases().iterator().next().getDisease().getName() + "1");
		Hibernate.initialize(p);
		Hibernate.initialize(p.getKnownDiseases());
		tx.commit();
		session.close();
		return p.getKnownDiseases();
	}

	@Override
	public List<Disease> getAllDiseases() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Disease> diseases = session.createQuery("select d from Disease d").list();
		tx.commit();
		session.close();
		return diseases;
	}

	@Override
	public void addDisease(int idpatient, int iddisease) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Patient p = (Patient)session.get(Patient.class, idpatient);
		Disease d= (Disease)session.get(Disease.class, iddisease);
		
		KnownDisease k = new KnownDisease();
		k.setDisease(d);
		k.setPatient(p);
		
		session.save(k);
		
		tx.commit();
		
		session.close();
		
	}

}
