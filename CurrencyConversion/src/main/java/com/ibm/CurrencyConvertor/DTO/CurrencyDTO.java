package com.ibm.CurrencyConvertor.DTO;

public class CurrencyDTO {

	private Long id;
	private String fromCountryCode;
	private String toCountryCode;
	private Long conversionFactor;
	
	
	
	public Long getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(Long conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromCountryCode() {
		return fromCountryCode;
	}
	public void setFromCountryCode(String fromCountryCode) {
		this.fromCountryCode = fromCountryCode;
	}
	public String getToCountryCode() {
		return toCountryCode;
	}
	public void setToCountryCode(String toCountryCode) {
		this.toCountryCode = toCountryCode;
	}
	
}
