
package my.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PayStub {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Start")
	private Date payPeriodStart;
	
	@Column(name="End")
	private Date payPeriodEnd;
	private float salary;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name= "PayStub_For")
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPayPeriodStart() {
		return payPeriodStart;
	}

	public void setPayPeriodStart(Date payPeriodStart) {
		this.payPeriodStart = payPeriodStart;
	}

	public Date getPayPeriodEnd() {
		return payPeriodEnd;
	}

	public void setPayPeriodEnd(Date payPeriodEnd) {
		this.payPeriodEnd = payPeriodEnd;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "PayStub [id=" + id + ", payPeriodStart=" + payPeriodStart + ", payPeriodEnd=" + payPeriodEnd
				+ ", salary=" + salary + ", employee=" + employee + "]";
	}

	
}
