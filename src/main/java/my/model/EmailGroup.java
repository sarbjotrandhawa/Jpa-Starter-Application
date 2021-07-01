package my.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class EmailGroup {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	@ManyToMany(mappedBy = "emailGroups")
	private List<Employee> members = new ArrayList<Employee>();

	public void setMembers(List<Employee> members) {
		this.members = members;
	}

	public List<Employee> getMembers() {
		return members;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addEmployee(Employee employee) {
		members.add(employee);
	}

	@Override
	public String toString() {
		return "EmailGroup [id=" + id + ", name=" + name + "]";
	}
	
	

}
