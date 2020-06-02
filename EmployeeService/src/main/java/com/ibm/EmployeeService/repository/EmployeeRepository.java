/**
 * 
 */
package com.ibm.EmployeeService.repository;

import org.springframework.stereotype.Repository;

import com.ibm.EmployeeService.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Deepika.Bansal
 *
 */
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
	
	

}
