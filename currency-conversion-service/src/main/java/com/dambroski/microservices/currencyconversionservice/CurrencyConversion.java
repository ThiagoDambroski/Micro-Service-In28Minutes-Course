package com.dambroski.microservices.currencyconversionservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversion {
	
	private Long id;
	private String coin1;
	private String coin2;
	private double quantity;
	private double conversionMultiple;
	private double total;
	private String environment;
}
