package my.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import my.model.AccessCard;
import my.model.Employee;
import my.model.EmployeeType;

public class JpaMainClass {

	public static void main(String args[]) {

		Employee e = new Employee();
		e.setName("sarbjot");
		e.setDate(new Date());
		e.setSsn("12345");
		e.setEmployeeType(EmployeeType.FULL_TIME);

		Employee e1 = new Employee();
		e1.setName("Jashan");
		e1.setDate(new Date());
		e1.setSsn("1934");
		e1.setEmployeeType(EmployeeType.PART_TIME);

		AccessCard card1 = new AccessCard();
		card1.setActive(true);
		card1.setIssueDate(new Date());
		card1.setFirmwareVersion("1.2.0");
		e.setCard(card1);

		AccessCard card2 = new AccessCard();
		card2.setActive(false);
		card2.setIssueDate(new Date());
		card2.setFirmwareVersion("1.2.0");
		e1.setCard(card2);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// Add Data into Database.

		entityTransaction.begin();
		entityManager.persist(e);
		entityManager.persist(e1);
		entityManager.persist(card1);
		entityManager.persist(card2);
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();

/*		
		
		// Find Data from database

		Employee employee = entityManager.find(Employee.class, 2);
		System.out.println(employee.toString());

		// Update Data into database

		employee.setEmployeeType(EmployeeType.CONTRACT);
		employee.setName("Sarbjot Singh");
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();

		// Delete data from database

		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		*/

	}
}
