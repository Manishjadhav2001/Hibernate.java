package utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Property;

import entertainment.entity.annotations.Movie;
import one_to_one.unidirectional.entity.Employee;
import one_to_one.unidirectional.entity.Passport;

public class HibernateUtils {
   public static SessionFactory getSessionFactory() {
	   Properties hibernateProperties =new Properties();
	   hibernateProperties.put("hibernate.connection.url","jdbc:mysql://localhost:3306/cdac");
	   hibernateProperties.put("hibernate.connection.username","root");
	   hibernateProperties.put("hibernate.connection.password","password");
	   hibernateProperties.put("hibernate.show_sql","true");
	   hibernateProperties.put("hibernate.hbm2ddl.auto","update");
	   
	   Configuration hibernateConfiguration = new Configuration();
	   hibernateConfiguration.setProperties(hibernateProperties);
	   
	   Class<Movie>entityType = Movie.class;
	   Class<Passport>entityType2=Passport.class;
	   Class<Employee>entityType3=Employee.class;
	   
	   
	   hibernateConfiguration.addAnnotatedClass(entityType);
	   hibernateConfiguration.addAnnotatedClass(entityType2);
	   hibernateConfiguration.addAnnotatedClass(entityType3);
	   
	   
	   SessionFactory factory = hibernateConfiguration.buildSessionFactory();
	   return factory;
   }
}
