package com.dambroski.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@GetMapping("/currencey-exchange/from/{coin1}/to/{coin2}")
	public CurrenctyExchange retriveExchangeValue(@PathVariable("coin1")String coin1,@PathVariable("coin2") String coin2)
			throws Exception {
		CurrenctyExchange currencty = repository.findByCoin1AndCoin2(coin1, coin2);
		if(currencty == null) {
			throw new RuntimeException("error");
		}
		String port = environment.getProperty("local.server.port");
		currencty.setEnvironment(port);
		return currencty;
	}
}
