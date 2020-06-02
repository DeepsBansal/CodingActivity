/**
 * 
 */
package com.ibm.CurrencyConvertor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.CurrencyConvertor.DTO.CurrencyDTO;
import com.ibm.CurrencyConvertor.DTO.CurrencyMapper;
import com.ibm.CurrencyConvertor.domain.Currency;
import com.ibm.CurrencyConvertor.repository.CurrencyRepository;
import java.util.Optional;


/**
 * @author Deepika Bansal
 * Currency MicroService
 *
 */
@Service
public class CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;
	

	public CurrencyDTO addConversionFactor(CurrencyDTO currencyDto) {
		CurrencyMapper mapper=new CurrencyMapper();
		Currency currency= mapper.convertCurrencyDTOToCurrency(currencyDto);
		
		Currency currency1= currencyRepository.save(currency);
		       return mapper.convertCurrencyToCurrencyDTO(currency1);
		
	}


	public CurrencyDTO updateConversionFactor(Long id, CurrencyDTO currencyDTO) {
		CurrencyMapper mapper=new CurrencyMapper();
		Optional<Currency> currency = currencyRepository.findById(id);
		
		if(currency.isPresent()) {
			Currency currency1 = new Currency();
			currency1.setId(currency.get().getId());
			currencyDTO.setId(currency.get().getId());
			currency1 = mapper.convertCurrencyDTOToCurrency(currencyDTO);
			//Update Currency
			Currency currency2= currencyRepository.save(currency1);
			return mapper.convertCurrencyToCurrencyDTO(currency2);
		}
		else {
			return null;
		}
		
	}


	public CurrencyDTO findByFromAndTo(String fromCountryCode, String toCountryCode) {
		CurrencyMapper mapper=new CurrencyMapper();
		Currency currency1 = currencyRepository.findByFromcountryAndTocountry(fromCountryCode, toCountryCode);   
		
		return mapper.convertCurrencyToCurrencyDTO(currency1);
	}

}
