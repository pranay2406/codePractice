package com.htc.MavenDemo.entity;

import java.util.Objects;

public class Employee {
	private String empId;
	private String empName;
	private String address;
	private String designation;
	private float salary;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, designation, empId, empName, salary);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(designation, other.designation)
				&& Objects.equals(empId, other.empId) && Objects.equals(empName, other.empName)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + ", designation="
				+ designation + ", salary=" + salary + "]";
	}
	public Employee(String empId, String empName, String address, String designation, float salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.designation = designation;
		this.salary = salary;
	}
	
	  
}
