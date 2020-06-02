package com.ibm.EmployeeService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Address-Service")
public interface RestClient {

	@GetMapping("/address")
	public String getAddress();
}
