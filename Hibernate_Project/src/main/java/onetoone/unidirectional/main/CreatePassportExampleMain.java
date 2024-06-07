package onetoone.unidirectional.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import one_to_one.unidirectional.entity.Passport;
import utils.HibernateUtils;

public class CreatePassportExampleMain {

	public static void main(String [] args) {
		try(
				SessionFactory sf=HibernateUtils.getSessionFactory();
				Session sessionRef = sf.openSession();
				
				){
			Passport p1 = new Passport("P123","Manish Jadhav",LocalDate.of(2030, 6, 12));
			Passport p2 = new Passport("P213","Manish Jadhav",LocalDate.of(2033, 4, 2));
			Transaction tx= sessionRef.beginTransaction();
			sessionRef.persist(p1);
			sessionRef.persist(p2);
			tx.commit();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
