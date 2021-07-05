package my.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import my.model.EmailGroup;
import my.model.Employee;

public class JpaUpdated {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee employee1 = entityManager.find(Employee.class, 2);
		EmailGroup emailGroup = entityManager.find(EmailGroup.class, 6);

		employee1.addEmailGroup(emailGroup);
		emailGroup.addEmployee(employee1);

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(employee1);
		entityManager.persist(emailGroup);

		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}
