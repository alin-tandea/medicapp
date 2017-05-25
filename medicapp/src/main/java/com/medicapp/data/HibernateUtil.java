package com.medicapp.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// loads configuration and mappings
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.medicapp.data.model.Patient.class);
			configuration.addAnnotatedClass(com.medicapp.data.model.Consultation.class);
			configuration.addAnnotatedClass(com.medicapp.data.model.Staff.class);
			configuration.addAnnotatedClass(com.medicapp.data.model.WorkSchedule.class);
			configuration.addAnnotatedClass(com.medicapp.data.model.Insurance.class);
			configuration.addAnnotatedClass(com.medicapp.data.model.Disease.class);
			configuration.addAnnotatedClass(com.medicapp.data.model.KnownDisease.class);
			configuration.addAnnotatedClass(com.medicapp.data.model.Drug.class);
			configuration.addAnnotatedClass(com.medicapp.data.model.Prescription.class);
			configuration.addAnnotatedClass(com.medicapp.data.model.BloodTest.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			// builds a session factory from the service registry
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}
}