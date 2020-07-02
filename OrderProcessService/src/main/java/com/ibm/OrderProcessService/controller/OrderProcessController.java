package com.ibm.OrderProcessService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.OrderProcessService.configurer.AuthenticationRequest;
import com.ibm.OrderProcessService.configurer.AuthenticationResponse;
import com.ibm.OrderProcessService.configurer.JwtUtil;
import com.ibm.OrderProcessService.models.OderDTO;
import com.ibm.OrderProcessService.service.MyUserDetailsService;



@RestController
public class OrderProcessController {

@Autowired
private MyUserDetailsService userDetailsService;

@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private JwtUtil jwtTokenUtil;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ResponseEntity<OderDTO> saveOrder(@RequestBody
	  OderDTO orderDTO){ OderDTO dto=userDetailsService.saveOrder(orderDTO);
	  return
	  ResponseEntity.ok().body(dto);
	  
	  }
	  
	  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
		public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
				);
			}
			catch (BadCredentialsException e) {
				throw new Exception("Incorrect username or password", e);
			}


			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());

			final String jwt = jwtTokenUtil.generateToken(userDetails);

			return ResponseEntity.ok(new AuthenticationResponse(jwt));
		}

	 
}
