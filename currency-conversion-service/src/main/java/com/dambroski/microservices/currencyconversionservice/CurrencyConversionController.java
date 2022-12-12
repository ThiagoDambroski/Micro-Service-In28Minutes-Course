package com.dambroski.microservices.currencyconversionservice;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	
	@Autowired
	CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion/from/{coin1}/to/{coin2}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable("quantity") double quantity,
			@PathVariable("coin1") String coin1,@PathVariable("coin2")String coin2) {
		
		HashMap<String,String> uriVariables = new HashMap<>();
		uriVariables.put("coin1",coin1);
		uriVariables.put("coin2", coin2);
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8000/currencey-exchange/from/USD/to/INR",
				CurrencyConversion.class,uriVariables);
		
		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		CurrencyConversion conversion = new CurrencyConversion(currencyConversion.getId()
				, coin1, coin2, quantity, currencyConversion.getConversionMultiple(),
				(quantity * currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
		return conversion;
	}
	
	@GetMapping("/currency-conversion-feign/from/{coin1}/to/{coin2}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable("quantity") double quantity,
			@PathVariable("coin1") String coin1,@PathVariable("coin2")String coin2) {
		
		
		
		CurrencyConversion currencyConversion = proxy.retriveExchangeValue(coin1, coin2);
		
		CurrencyConversion conversion = new CurrencyConversion(currencyConversion.getId()
				, coin1, coin2, quantity, currencyConversion.getConversionMultiple(),
				(quantity * currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
		return conversion;
	}
}
