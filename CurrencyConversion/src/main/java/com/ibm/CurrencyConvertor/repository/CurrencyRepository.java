package com.ibm.CurrencyConvertor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.CurrencyConvertor.domain.Currency;

public interface CurrencyRepository  extends JpaRepository<Currency,Long>{

	Currency findByFromcountryAndTocountry(String fromCountryCode, String toCountryCode);

	
}
