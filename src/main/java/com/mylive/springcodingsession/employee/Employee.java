package com.mylive.springcodingsession.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="id_employee")
	private Integer idEmployee;
	
	@Size(min=2, message="Name should have at least 2 characters")
	@Column(name="name_employee")
	private String nameEmployee;
	
	@Past
	@Column(name="birth_date")
	private Date birthDate;

	protected Employee() {
	}
	
	public Employee(Integer idEmployee, String nameEmployee, Date birthDate) {
		super();
		this.idEmployee = idEmployee;
		this.nameEmployee = nameEmployee;
		this.birthDate = birthDate;
	}
	
	public Integer getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getNameEmployee() {
		return nameEmployee;
	}
	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "User [id=" + idEmployee + ", name=" + nameEmployee + ", birthDate=" + birthDate + "]";
	}
	
}
