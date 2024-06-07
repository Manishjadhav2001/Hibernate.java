package main.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entertainment.entity.annotations.Movie;
import utils.HibernateUtils;

public class RecordUpdateMain {

	public static void main(String []args) {
		try(
				SessionFactory sf=HibernateUtils.getSessionFactory();
				Session sessionRef = sf.openSession();
				
				){
			 Class<Movie>entityType = Movie.class;
			 Object identity =101;
			 Movie foundmovie =sessionRef.find(entityType, identity);
			 Transaction tx = sessionRef.beginTransaction();
			 foundmovie.setTitle("RRR2");
			 foundmovie.setYear(2024);
			 tx.commit();
			 System.out.println("record update");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
}
}