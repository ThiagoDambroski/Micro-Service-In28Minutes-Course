package com.dambroski.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class CurrenctyExchange {
	
	@Id
	@GeneratedValue(generator = "currency_id",strategy = GenerationType.IDENTITY)
	private Long id;
	private String coin1;
	private String coin2;
	private BigDecimal conversionMultiple;
	private String environment;

}
