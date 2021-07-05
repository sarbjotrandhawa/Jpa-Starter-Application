package my.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import my.model.Employee;

public class JpaJPQLExample {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Employee> query = entityManager.createQuery("Select e from Employee e", Employee.class);
		List<Employee> list = query.getResultList();
		list.forEach(System.out::println);

		System.out.println("----------------------------------------");

		TypedQuery<Employee> query1 = entityManager.createQuery("Select e from Employee e order by e.id desc",
				Employee.class);
		List<Employee> list1 = query1.getResultList();
		list1.forEach(System.out::println);

		System.out.println("----------------------------------------");

		TypedQuery<Employee> query2 = entityManager.createQuery("Select e from Employee e where e.name like '%t'",
				Employee.class);
		List<Employee> list2 = query2.getResultList();
		list2.forEach(System.out::println);

		System.out.println("----------------------------------------");

		TypedQuery<Employee> query3 = entityManager.createQuery("Select e from Employee e where e.id between 8 and 11",
				Employee.class);
		List<Employee> list3 = query3.getResultList();
		list3.forEach(System.out::println);

		System.out.println("----------------------------------------");

		TypedQuery<Employee> query4 = entityManager.createQuery("Select e from Employee e where e.card.isActive = true",
				Employee.class);
		List<Employee> list4 = query4.getResultList();
		list4.forEach(System.out::println);

		System.out.println("----------------------------------------");

		TypedQuery<Employee> query5 = entityManager.createQuery(
				"Select e from Employee e join AccessCard a on e.id=a.id and a.isActive = true", Employee.class);
		List<Employee> list5 = query5.getResultList();
		list5.forEach(System.out::println);

		System.out.println("----------------------------------------");

		TypedQuery<String> query6 = entityManager.createQuery("Select e.name from Employee e", String.class);
		List<String> list6 = query6.getResultList();
		list6.forEach(System.out::println);

		System.out.println("----------------------------------------");

		TypedQuery<Integer> query7 = entityManager.createQuery("Select e.id from Employee e", Integer.class);
		List<Integer> list7 = query7.getResultList();
		list7.forEach(System.out::println);

		System.out.println("----------------------------------------");

		TypedQuery<Object[]> query8 = entityManager.createQuery("Select e.id,e.name from Employee e", Object[].class);
		List<Object[]> list8 = query8.getResultList();
		list8.forEach(e -> System.out.println(e[0] + " " + e[1]));

		System.out.println("----------------------------------------");

		TypedQuery<Object[]> query9 = entityManager.createQuery(
				"Select e.id,c.issueDate from Employee e, AccessCard c where e.card.id = c.id", Object[].class);
		List<Object[]> list9 = query9.getResultList();
		list9.forEach(e -> System.out.println(e[0] + " " + e[1]));

		System.out.println("----------------------------------------");

		TypedQuery<Object[]> query10 = entityManager.createQuery("Select e.id,e.card.firmwareVersion from Employee e",
				Object[].class);
		List<Object[]> list10 = query10.getResultList();
		list10.forEach(e -> System.out.println(e[0] + " " + e[1]));

		System.out.println("----------------------------------------");

		int eid = 1;

		TypedQuery<Employee> query11 = entityManager.createQuery("Select e from Employee e where e.id = :eid",
				Employee.class);
		query11.setParameter("eid", eid);
		List<Employee> list11 = query11.getResultList();
		list11.forEach(System.out::println);

		System.out.println("----------------------------------------");

		TypedQuery<Employee> query12 = entityManager.createNamedQuery("emp_name_asc", Employee.class);
		List<Employee> list12 = query12.getResultList();
		list12.forEach(System.out::println);
		
		System.out.println("----------------------------------------");

		TypedQuery<Employee> query13 = entityManager.createNamedQuery("EMP_By_Id", Employee.class);
		query13.setParameter("eid", 1);
		List<Employee> list13 = query13.getResultList();
		list13.forEach(System.out::println);

	}

}
