package my.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import my.model.Employee;
import my.model.PayStub;

public class JpaReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		/*
		Employee employee = entityManager.find(Employee.class, 1);
		System.out.println(employee.toString());
		
		System.out.println("--------- Lazy Fetch ---------");
		System.out.println(employee.getCard());
		*/
		
		Employee employee = entityManager.find(Employee.class, 1);
		System.out.println("-------------------------------------");
		System.out.println(employee.getPaystub().get(1));

	}

}
