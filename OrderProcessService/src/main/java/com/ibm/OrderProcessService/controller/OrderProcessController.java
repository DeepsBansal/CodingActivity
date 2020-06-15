package com.ibm.OrderProcessService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.OrderProcessService.models.OderDTO;
import com.ibm.OrderProcessService.service.MyUserDetailsService;

@RestController
public class OrderProcessController {

@Autowired
private MyUserDetailsService service;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	
	  @PostMapping("/save") public ResponseEntity<OderDTO> saveOrder(@RequestBody
	  OderDTO orderDTO){ OderDTO dto=service.saveOrder(orderDTO); return
	  ResponseEntity.ok().body(dto);
	  
	  }
	 
}
