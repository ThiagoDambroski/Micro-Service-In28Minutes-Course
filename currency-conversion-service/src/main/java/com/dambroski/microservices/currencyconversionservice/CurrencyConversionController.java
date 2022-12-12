package com.dambroski.microservices.currencyconversionservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
	
	@GetMapping("/currency-conversion/from/{coin1}/to/{coin2}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable("quantity") double quantity,
			@PathVariable("coin1") String coin1,@PathVariable("coin2")String coin2) {
		CurrencyConversion conversion = new CurrencyConversion(10001L, coin1, coin2, quantity, 1.0, 1.0,"");
		return conversion;
	}
}
