package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entertainment.entity.Movie;

public class RecordInsertionExampleMain {

	public static void main(String[] args) {
		// step1
		Configuration hibernateconfig = new Configuration();
		hibernateconfig = hibernateconfig.configure();

		// Step 2
		SessionFactory hibernateFactory = hibernateconfig.buildSessionFactory();

		// step3
		Session hibernateSeccion = hibernateFactory.openSession();

		// step4
		Movie movieObj = new Movie(103, "rrr", "action", 2024);

		// step5
		Transaction hibernateTransaction = hibernateSeccion.beginTransaction();

		// Step 6
		hibernateSeccion.persist(movieObj);

		// Step7
		hibernateTransaction.commit();

		// Step8
		hibernateSeccion.close();

		// Step 9
		hibernateFactory.close();

		System.out.println("record inserted");
	}
}
