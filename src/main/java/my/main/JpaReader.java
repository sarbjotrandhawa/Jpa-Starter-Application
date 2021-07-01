package my.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import my.model.AccessCard;
import my.model.EmailGroup;
import my.model.Employee;
import my.model.PayStub;

public class JpaReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Fetch Employee with an Id;
		Employee employee1 = entityManager.find(Employee.class, 1);
		System.out.println(employee1.toString());

		System.out.println("************************  Fetch one to one. ***********************************");

		// Fetch one to one.
		// Fetch card associated with Employee.
		System.out.println("--------- Lazy Fetch ---------");
		System.out.println(employee1.getCard());

		AccessCard c = entityManager.find(AccessCard.class, 1);
		//System.out.println(c.getEmployee().toString());

		System.out.println("************************* Many to one, One to Many *****************************");

		// One to many, One Employee may have multiple pay Stubs.
		// Fetch all the pay-stubs associated with employee.
		Employee employee2 = entityManager.find(Employee.class, 1);
		List<PayStub> payStubs = employee2.getPaystub();
		for (PayStub payStub : payStubs) {
			System.out.println(payStub.toString());
		}

		//ManyToOne, Many pay-stub may be associated with one Employees.
		// Find  Employees associated with a pay-stub.
		System.out.println("=======================================");
		
		PayStub payStub = entityManager.find(PayStub.class, 4);
		System.out.println(payStub.getEmployee().toString());
		

		System.out.println("************************* Fetch Many to Many **********************************");

		// Many To Many fetch
		// Find all employees with group ID.
		EmailGroup emailGroup = entityManager.find(EmailGroup.class, 6);

		List<Employee> e = emailGroup.getMembers();

		for (Employee emp : e) {
			System.out.println(emp.toString());
		}

		// Find all groups associated with am Employee
		System.out.println("=======================================");
		Employee employee = entityManager.find(Employee.class, 1);
		List<EmailGroup> gp = employee1.getEmailGroups();
		for (EmailGroup eg : gp) {
			System.out.println(eg.toString());
		}

	}

}
