package com.medicapp.data.access;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.medicapp.data.HibernateUtil;
import com.medicapp.data.model.BloodTest;
import com.medicapp.data.model.Consultation;

public class BloodTestDAOImpl implements BloodTestDAO{

	private SessionFactory sessionFactory;
	
	public BloodTestDAOImpl(){
		super();
		this.sessionFactory = HibernateUtil.getSessionFactory();
		
	}
	
	@Override
	public BloodTest getTest(int idcons) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Consultation c = (Consultation)session.get(Consultation.class, idcons);
		
		if(c.getTests().iterator().hasNext()){
			tx.commit();
			session.close();
			
			return c.getTests().iterator().next();
		}else{
			tx.commit();
			session.close();
			
			return null;
		}
	}

	@Override
	public void addTest(int idcons, String hgb, String paletets, String vsh, String tsh, String mg, String fe) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		BloodTest b = new BloodTest();
		
		Consultation c = (Consultation)session.get(Consultation.class, idcons);
		
		b.setHgb(hgb);
		b.setPaletets(paletets);
		b.setVsh(vsh);
		b.setTsh(tsh);
		b.setMg(mg);
		b.setFe(fe);
		
		b.setConsultation(c);
		
		session.save(b);
		tx.commit();
		session.close();
		
		
		
	}

}
