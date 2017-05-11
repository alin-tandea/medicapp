package com.medicapp.data.access;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.medicapp.data.HibernateUtil;
import com.medicapp.data.model.Staff;
import com.medicapp.data.model.WorkSchedule;
import com.medicapp.service.WorkScheduleService;

public class StaffDAOImpl implements StaffDAO {

	private SessionFactory sessionFactory;

	public StaffDAOImpl() {
		super();
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public void addStaff(String name, String username, String password, int role) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Staff s = new Staff();
		s.setName(name);
		s.setUsername(username);
		s.setPassword(password);
		s.setRole(role);
		Integer id = (Integer) session.save(s);
		tx.commit();
		session.close();
		if (role == 1) {
			for (int i = 1; i < 8; i++) {
				WorkSchedule[] w = new WorkSchedule[8];
				w[i] = new WorkSchedule();
				w[i].setWorkday(i);
				w[i].setStartHour(-1);
				w[i].setEndHour(-1);
				WorkScheduleService.addWorkSchedule(w[i], id.intValue());
			}
		}
	}

	@Override
	public void updateStaff(int idstaff, String name, String username, String password, int role) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Staff s = session.get(Staff.class, idstaff);
		s.setName(name);
		s.setUsername(username);
		s.setPassword(password);
		s.setRole(role);
		session.update(s);
		tx.commit();
		session.close();

	}

	@Override
	public void deleteStaff(int idstaff) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Staff s = session.get(Staff.class, idstaff);
		session.delete(s);
		tx.commit();
	}

	@Override
	public ArrayList<Staff> getAllStaff() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Staff> staff = session.createQuery("select s from Staff s").list();
		tx.commit();
		return (ArrayList<Staff>) staff;
	}

	@Override
	public Staff getStaff(int idstaff) {
		return getAllStaff().stream().filter(s -> s.getIdstaff() == idstaff).findFirst().get();
	}

}
