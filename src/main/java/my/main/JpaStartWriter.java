package my.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import my.model.AccessCard;
import my.model.EmailGroup;
import my.model.Employee;
import my.model.EmployeeType;
import my.model.PayStub;

public class JpaStartWriter {

	public static void main(String[] args) {

		Employee e = new Employee();
		e.setName("sarbjot");
		e.setDate(new Date());
		e.setSsn("12345");
		e.setEmployeeType(EmployeeType.FULL_TIME);

		Employee e1 = new Employee();
		e1.setName("Karan");
		e1.setDate(new Date());
		e1.setSsn("13456");
		e1.setEmployeeType(EmployeeType.PART_TIME);

		// One to Many relationship, One employee belongs to Many Paystubs and
		// Many Paystubs belongs to one Employee.
		PayStub payStub = new PayStub();
		payStub.setPayPeriodEnd(new Date());
		payStub.setPayPeriodStart(new Date());
		payStub.setEmployee(e);
		e.addPayStub(payStub);
		payStub.setSalary(1500);

		PayStub payStub1 = new PayStub();
		payStub1.setPayPeriodEnd(new Date());
		payStub1.setPayPeriodStart(new Date());
		payStub1.setSalary(2000);
		payStub1.setEmployee(e);
		e.addPayStub(payStub1);

		// Many to many Relationship, Many employees can be the part of Many group or
		// Many group can contain many employees.
		EmailGroup emailGroup1 = new EmailGroup();
		emailGroup1.setName("Java Group");
		emailGroup1.addEmployee(e);
		e.addEmailGroup(emailGroup1);

		EmailGroup emailGroup2 = new EmailGroup();
		emailGroup2.setName("C++ Group");
		emailGroup2.addEmployee(e);
		e.addEmailGroup(emailGroup2);
		emailGroup2.addEmployee(e1);
		e1.addEmailGroup(emailGroup2);

		// One to One relationship, One Card belongs to only one Employee
		// one Employee to only ine card.
		AccessCard card1 = new AccessCard();
		card1.setActive(true);
		card1.setIssueDate(new Date());
		card1.setFirmwareVersion("1.2.0");

		e.setCard(card1);
		card1.setEmployee(e);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(e);
		entityManager.persist(e1);
		entityManager.persist(card1);
		entityManager.persist(payStub);
		entityManager.persist(payStub1);
		entityManager.persist(emailGroup1);
		entityManager.persist(emailGroup2);

		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}
