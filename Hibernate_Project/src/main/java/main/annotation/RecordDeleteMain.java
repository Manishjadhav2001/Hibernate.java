package main.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entertainment.entity.annotations.Movie;
import utils.HibernateUtils;

public class RecordDeleteMain {

	public static void main(String []args) {
		try(
				SessionFactory sf=HibernateUtils.getSessionFactory();
				Session sessionRef = sf.openSession();
				
				){
			 Class<Movie>entityType = Movie.class;
			 Object identity =102;
			 Movie foundmovie =sessionRef.find(entityType, identity);
			 Transaction tx = sessionRef.beginTransaction();
			 sessionRef.remove(foundmovie);
			 tx.commit();
			 System.out.println("record delete");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
}
}