/**
 * 
 */
package com.ibm.ConvertCurrency.DTO;

/**
 * @author Deepika Bansal
 *
 */
public class ConvertorDTO {

	private String from_currency_code;
	
	
	private Long amount_to_convert;

	

	public Long getAmount_to_convert() {
		return amount_to_convert;
	}

	public void setAmount_to_convert(Long amount_to_convert) {
		this.amount_to_convert = amount_to_convert;
	}



	public String getFrom_currency_code() {
		return from_currency_code;
	}

	public void setFrom_currency_code(String from_currency_code) {
		this.from_currency_code = from_currency_code;
	}
	
	
}
