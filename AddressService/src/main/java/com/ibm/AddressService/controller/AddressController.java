package com.ibm.AddressService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

	@GetMapping("/address")
	public String getAddress() {
		System.out.println("Inside Feign Address Controller");
		return ("Feign-Address");
	}
}
