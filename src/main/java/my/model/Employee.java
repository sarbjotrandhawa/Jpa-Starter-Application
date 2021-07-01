package my.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "EmployeeName", length = 100)
	private String name;

	@Column(name = "SSN", unique = true, updatable = false)
	private String ssn;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;

	@Transient
	private String extra;

	@OneToOne
	private AccessCard card;

	@OneToMany(mappedBy = "employee")
	private List<PayStub> paystub = new ArrayList<PayStub>();
	
	
	@ManyToMany(mappedBy="members")
	private List<EmailGroup> emailGroups = new ArrayList<EmailGroup>();
	


	public List<EmailGroup> getEmailGroups() {
		return emailGroups;
	}

	public void setEmailGroups(List<EmailGroup> emailGroups) {
		this.emailGroups = emailGroups;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public AccessCard getCard() {
		return card;
	}

	public void setCard(AccessCard card) {
		this.card = card;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public List<PayStub> getPaystub() {
		return paystub;
	}

	public void setPaystub(List<PayStub> paystub) {
		this.paystub = paystub;
	}
	
	public void addPayStub(PayStub payStub)
	{
		this.paystub.add(payStub);
	}

	public void addEmailGroup(EmailGroup emailGroup)
	{
		emailGroups.add(emailGroup);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", ssn=" + ssn + ", date=" + date + ", employeeType="
				+ employeeType + ", extra=" + extra + ", card=" + card + "]";
	}

}
