package my.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import my.model.Employee;
import my.model.EmployeeType;

public class JpaMainClass {

	public static void main(String args[]) {
		
		Employee e = new Employee();
		e.setId(1);
		e.setName("sarbjot");
		e.setDate(new Date());
		e.setSsn("12345");
		e.setEmployeeType(EmployeeType.FULL_TIME);
		
		Employee e1 = new Employee();
		e1.setId(2);
		e1.setName("Jashan");
		e1.setDate(new Date());
		e1.setSsn("19345");
		e1.setEmployeeType(EmployeeType.PART_TIME);
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(e);
		entityTransaction.commit();
		
	}
}
