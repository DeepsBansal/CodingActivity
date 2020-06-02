package com.ibm.CurrencyConvertor.DTO;

import com.ibm.CurrencyConvertor.domain.Currency;

public class CurrencyMapper {

public CurrencyDTO convertCurrencyToCurrencyDTO(Currency currency) {
		
	CurrencyDTO currencyDTO=new CurrencyDTO();
		currencyDTO.setId(currency.getId());
		currencyDTO.setFromCountryCode(currency.getFromcountry());
		currencyDTO.setToCountryCode(currency.getTocountry());
		currencyDTO.setConversionFactor(currency.getConversionfactor());	
		return currencyDTO;
	}
	
	public Currency convertCurrencyDTOToCurrency(CurrencyDTO currencyDTO) {
		
		Currency currency=new Currency();
		currency.setId(currencyDTO.getId());
		currency.setFromcountry(currencyDTO.getFromCountryCode());
		currency.setTocountry(currencyDTO.getToCountryCode());
		currency.setConversionfactor(currencyDTO.getConversionFactor());
		return currency;
	}
			
}
