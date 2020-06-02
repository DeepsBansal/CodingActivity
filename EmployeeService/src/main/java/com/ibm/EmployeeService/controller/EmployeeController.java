package com.ibm.EmployeeService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.EmployeeService.dto.EmployeeDTO;
import com.ibm.EmployeeService.service.EmployeeService;


@RestController
@RequestMapping("employee")
@RefreshScope
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> searchByEmployeeID(@PathVariable(value="id") int id) {
	if(employeeService.getEmployeeById(id).getEmpname() == null)	
		return new ResponseEntity<EmployeeDTO>(employeeService.getEmployeeById(id),HttpStatus.NOT_FOUND);
	else
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}
	
}
