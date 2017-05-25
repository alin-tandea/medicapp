package com.medicapp.data.access;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.medicapp.data.HibernateUtil;
import com.medicapp.data.model.Consultation;
import com.medicapp.data.model.Disease;
import com.medicapp.data.model.Drug;
import com.medicapp.data.model.Prescription;

public class DrugDAOImpl implements DrugDAO{
	
	private SessionFactory sessionFactory;

	public DrugDAOImpl(){
		super();
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public List<Drug> getAllDrugsConsultation(int idconsultation) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Consultation c = (Consultation)session.get(Consultation.class, idconsultation);
		
		Set<Prescription> pres = c.getPrescriptions();
		
		
		List<Drug> res = new ArrayList<Drug>();
		
		for(Prescription p : pres){
			res.add(p.getDrug());
		}
		tx.commit();
		session.close();
		return res;
	}

	@Override
	public void addDrugOnPrescription(int idconsultation, int iddrug , Date date) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Consultation c = (Consultation)session.get(Consultation.class, idconsultation);
		
		Drug d = (Drug)session.get(Drug.class, iddrug);
		
		Prescription p = new Prescription();
		
		p.setConsultation(c);
		p.setDrug(d);
		p.setDate(date);
		
		session.save(p);
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Drug> getAllDrugs() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Drug> drugs = session.createQuery("select d from Drug d").list();
		tx.commit();
		session.close();
		return drugs;
	}

}
