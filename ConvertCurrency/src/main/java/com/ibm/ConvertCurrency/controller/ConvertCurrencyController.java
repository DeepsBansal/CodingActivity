package com.ibm.ConvertCurrency.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ConvertCurrency.DTO.ConvertorDTO;
import com.ibm.ConvertCurrency.DTO.ResponseDTO;


@RestController
@RequestMapping("Convertor")
public class ConvertCurrencyController {

	@PostMapping("/converted-amount")
	public ResponseEntity<ResponseDTO>  amount(@RequestBody ConvertorDTO convertorDTO) {
		ResponseDTO dto = new ResponseDTO();
		if(convertorDTO.getFrom_currency_code().equalsIgnoreCase("INR")) {
			
			
				 dto.setDollar(convertorDTO.getAmount_to_convert() / 75.68);
				 dto.setEuro(convertorDTO.getAmount_to_convert() / 83.06);
				 dto.setPound(convertorDTO.getAmount_to_convert() / 93.22);
				 dto.setYen(convertorDTO.getAmount_to_convert() / 1.42);
		 	return ResponseEntity.ok().body(dto);		
		}if(convertorDTO.getFrom_currency_code().equalsIgnoreCase("USD")) {
		
			dto.setRupee(convertorDTO.getAmount_to_convert() *75.68);
			 dto.setEuro(convertorDTO.getAmount_to_convert() *1.10);
			 dto.setPound(convertorDTO.getAmount_to_convert() *1.23);
			 dto.setYen(convertorDTO.getAmount_to_convert() *107.43);
			
			 return ResponseEntity.ok().body(dto);
		
		
	} else {
		return (ResponseEntity<ResponseDTO>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
	}
	}		
}
