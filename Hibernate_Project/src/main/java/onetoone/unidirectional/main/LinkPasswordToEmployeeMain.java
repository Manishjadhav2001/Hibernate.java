package onetoone.unidirectional.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import one_to_one.unidirectional.entity.Employee;
import one_to_one.unidirectional.entity.Passport;
import utils.HibernateUtils;

public class LinkPasswordToEmployeeMain {

	public static void main(String []args) {
		try(
				SessionFactory sf=HibernateUtils.getSessionFactory();
				Session sessionRef = sf.openSession();
				
				){
			Class<Passport> passportType = Passport.class;
			Class<Employee> employeeType =Employee.class;
			
			Passport p1 = sessionRef.find(passportType, "P123");
			Passport p2 = sessionRef.find(passportType, "P213");
			Employee e1= sessionRef.find(employeeType, "123");
			Employee e2= sessionRef.find(employeeType, "132");
			Transaction tx= sessionRef.beginTransaction();
			e1.setPassportref(p1);
			e2.setPassportref(p2);
			tx.commit();
			System.out.println("link with emp");
		}
		
		
	}
}
