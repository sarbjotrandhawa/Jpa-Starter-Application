package my.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import my.model.Employee;
import my.model.EmployeeType;

public class JpaPersistenceCotextDemo {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee employee = new Employee();

		employee.setName("Check");
		employee.setDate(new Date());
		employee.setEmployeeType(EmployeeType.CONTRACT);

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		
		entityManager.persist(employee);
		Employee employee1 = entityManager.find(Employee.class, 12);

		System.out.println(employee);
		System.out.println(employee1);
		//both are same, it is not into the db  still is in context.
		System.out.println(employee==employee1);

		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}
