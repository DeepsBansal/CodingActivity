package com.ibm.EmployeeService.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.EmployeeService.client.RestClient;
import com.ibm.EmployeeService.domain.Employee;
import com.ibm.EmployeeService.dto.EmployeeDTO;
import com.ibm.EmployeeService.repository.EmployeeRepository;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeeService {

	final RestClient restClient;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(RestClient restClient) {
		this.restClient=restClient;
	}
	
	@HystrixCommand(fallbackMethod="addressServiceFallback")
	public EmployeeDTO getEmployeeById(long id) {
		EmployeeDTO employeeDTO =new EmployeeDTO();
		Optional<Employee> employee = employeeRepository.findById( id);
		if(employee.isPresent()) {
			String address = restClient.getAddress();
			employeeDTO=convertEmployeeToEmployeeDTO(employee,employeeDTO,address);
		}
		return employeeDTO;
	}
	
	@SuppressWarnings("unused")
	private EmployeeDTO convertEmployeeToEmployeeDTO(Optional<Employee> employee, EmployeeDTO employeeDTO,String address) {
		employeeDTO.setAge(employee.get().getAge());
		employeeDTO.setEmpname(employee.get().getEmpname());
		employeeDTO.setAddress(address);
		return employeeDTO;
		
	}

	public EmployeeDTO addressServiceFallback(long id) {
		EmployeeDTO employeeDTO =new EmployeeDTO();
		Optional<Employee> employee = employeeRepository.findById( id);
		if(employee.isPresent()) {
			String address ="Hystrix-Address";
			employeeDTO=convertEmployeeToEmployeeDTO(employee,employeeDTO,address);
		}
	return employeeDTO;
	}
	

}
