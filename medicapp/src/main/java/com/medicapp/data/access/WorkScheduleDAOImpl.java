package com.medicapp.data.access;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.medicapp.data.HibernateUtil;
import com.medicapp.data.model.Staff;
import com.medicapp.data.model.WorkSchedule;

@SuppressWarnings("deprecation")
public class WorkScheduleDAOImpl implements WorkScheduleDAO{
	private SessionFactory sessionFactory;
	
	
	public WorkScheduleDAOImpl() {
		super();
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}



	@Override
	public List<WorkSchedule> getEntireSchedule(int idstaff) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<WorkSchedule> query = session.createQuery("select s from WorkSchedule s where staff_idstaff = :idstaff");
		query.setParameter("idstaff", idstaff);
		tx.commit();
		return query.list();
	

	}


	@Override
	public WorkSchedule getSchedule(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		WorkSchedule w = session.get(WorkSchedule.class, id);
		tx.commit();
		return w;
	}


	@Override
	public void updateSchedule(int idWorkSchedule, int day, int startHour, int endHour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		WorkSchedule w = session.get(WorkSchedule.class, idWorkSchedule);
		System.out.println("id = " + idWorkSchedule + "  " + w);
		w.setWorkday(day);
		w.setStartHour(startHour);
		w.setEndHour(endHour);
		session.save(w);
		tx.commit();
		
	}


	@Override
	public void addSchedule(int day, int startHour, int endHour, int idstaff) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Staff s = session.get(Staff.class, idstaff);
		WorkSchedule w = new WorkSchedule();
		System.out.println(s);
		w.setWorkday(day);
		w.setStartHour(startHour);
		w.setEndHour(endHour);
		w.setStaff(s);
		s.getWorkdays().add(w);
		session.save(s);
		session.save(w);
		tx.commit();
	}
	
	
}
