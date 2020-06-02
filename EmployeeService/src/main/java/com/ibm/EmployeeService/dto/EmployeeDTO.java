/**
 * 
 */
package com.ibm.EmployeeService.dto;

/**
 * @author Deepika Bansal
 *
 */
public class EmployeeDTO {

	
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String empname;
	private int age;
	private String  address;
	
}
