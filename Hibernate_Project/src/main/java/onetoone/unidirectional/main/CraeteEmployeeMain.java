package onetoone.unidirectional.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import one_to_one.unidirectional.entity.Employee;
import utils.HibernateUtils;

public class CraeteEmployeeMain {
	
	
	public static void main(String [] args) {
		try(
				SessionFactory sf=HibernateUtils.getSessionFactory();
				Session sessionRef = sf.openSession();
				
				){
			Employee e1 = new Employee(132, "Pavan jadhav", 40000, null);
			Transaction tx= sessionRef.beginTransaction();
			sessionRef.persist(e1);
			
			tx.commit();
		}
	
	catch(Exception ex) {
		ex.printStackTrace();
	}
	}

}
