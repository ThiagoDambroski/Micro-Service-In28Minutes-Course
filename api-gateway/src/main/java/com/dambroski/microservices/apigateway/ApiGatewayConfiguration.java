package com.dambroski.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f
								.addRequestHeader("MyHeader", "MyURI")
								.addRequestHeader("Param", "MyValue"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currencey-excange/**")
						.uri("lb://currency-exchange"))
				.route(p -> p.path("/currencey-conversion/**")
						.uri("lb://currency-conversion"))
				.route(p -> p.path("/currencey-conversion-feign/**")
						.uri("lb://currency-conversion"))
				.route(p -> p.path("/currencey-conversion-new/**")
						.filters(f -> f.rewritePath("/currencey-conversion-new/(?<segment>.*)", 
								"/currencey-conversion-feign/${segment}"))
						.uri("lb://currency-conversion"))
					
				.build();
		                     
	}
}
