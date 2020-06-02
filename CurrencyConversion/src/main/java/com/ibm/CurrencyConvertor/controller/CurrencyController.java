
package com.ibm.CurrencyConvertor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.CurrencyConvertor.DTO.CurrencyDTO;
import com.ibm.CurrencyConvertor.Service.CurrencyService;



/**
 * @author Deepika Bansal
 *  Activity Microservice-1 for Add, Update and get Conversion Factor
 *
 */

@RestController
@RequestMapping("Currency")
public class CurrencyController {

	@Autowired
	public CurrencyService currencyService;
	
	@GetMapping("/msg")
	public String addConverisonFactor() {	
		return "Hello World";
	}
	
	@PostMapping("/add")
	public ResponseEntity<CurrencyDTO> addConversionFactor(@RequestBody CurrencyDTO  currencyDTO){
		CurrencyDTO currencyDto=currencyService.addConversionFactor(currencyDTO);
		return ResponseEntity.ok().body(currencyDto);
		
	}

	@PutMapping("/update/{id}") 
	  public ResponseEntity<CurrencyDTO> updateConversionFactor(@PathVariable(value = "id") Long id,
	   @RequestBody CurrencyDTO currencyDTO){
	  
	  CurrencyDTO currencyDto=currencyService.updateConversionFactor(id,currencyDTO); return
	  ResponseEntity.ok().body(currencyDto);
	  
	  }
	
	  @GetMapping("get/{fromCountryCode}/{toCountryCode}")
	  public ResponseEntity<CurrencyDTO> getConversionFactor(@PathVariable(value = "fromCountryCode") String fromCountryCode,
	  @PathVariable(value = "toCountryCode") String toCountryCode ){
		 
	    return ResponseEntity.ok().body(currencyService.findByFromAndTo(fromCountryCode,toCountryCode));
	  }
}
