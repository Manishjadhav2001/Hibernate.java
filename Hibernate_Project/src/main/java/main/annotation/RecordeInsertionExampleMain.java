package main.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entertainment.entity.annotations.Movie;
import utils.HibernateUtils;

public class RecordeInsertionExampleMain {

	public static void main(String []args) {
		try(
				SessionFactory sf=HibernateUtils.getSessionFactory();
				Session sessionRef = sf.openSession();
				
				){
			Movie movieObj = new Movie(103,"Dhamal","comedy",1997);
			Transaction tx= sessionRef.beginTransaction();
			sessionRef.persist(movieObj);
			tx.commit();
			System.out.println("record inserted");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
}
