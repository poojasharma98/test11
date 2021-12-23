package com.test;

public class Employee {
	private String name;
	private String eid;
	private String email;
	private String dept;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + ", email=" + email + ", dept=" + dept + ", address="
				+ address + "]";
	}

	public Employee(String name, String eid, String email, String dept, String address) {
		super();
		this.name = name;
		this.eid = eid;
		this.email = email;
		this.dept = dept;
		this.address = address;
	}

}
