package com.dambroski.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "currencey-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currencey-exchange/from/{coin1}/to/{coin2}")
	public CurrencyConversion retriveExchangeValue(@PathVariable("coin1")String coin1,@PathVariable("coin2") String coin2);
	
}
