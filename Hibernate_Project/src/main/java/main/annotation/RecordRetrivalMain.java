package main.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entertainment.entity.annotations.Movie;
import utils.HibernateUtils;

public class RecordRetrivalMain {
	public static void main(String []args) {
		try(
				SessionFactory sf=HibernateUtils.getSessionFactory();
				Session sessionRef = sf.openSession();
				
				){
			 Class<Movie>entityType = Movie.class;
			 Object identity =111;
			 Movie foundmovie =sessionRef.find(entityType, identity);
			 if(foundmovie!=null) {
			 System.out.println(foundmovie);
			 System.out.println("Title:"+foundmovie.getTitle());
			 }else {
				 System.out.println("movie not found");
			 }
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
}
}