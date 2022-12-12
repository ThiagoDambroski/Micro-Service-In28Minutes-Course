package com.dambroski.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrenctyExchange, Long>{
	
	CurrenctyExchange findByCoin1AndCoin2(String coin1,String coin2);

}
