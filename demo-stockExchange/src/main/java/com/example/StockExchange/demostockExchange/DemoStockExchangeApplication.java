package com.example.StockExchange.demostockExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.StockExchange.demostockExchange.entity.Company;
import com.example.StockExchange.demostockExchange.repository.Companyrepository;

//@SpringBootApplication
//public class DemoStockExchangeApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoStockExchangeApplication.class, args);
//	}
//
//}


@SpringBootApplication
@ComponentScan(basePackages = "com.example.StockExchange.demostockExchange", basePackageClasses = { Company.class, Companyrepository.class })
public class DemoStockExchangeApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoStockExchangeApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoStockExchangeApplication.class, args);
		
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
			//this is done to avoid cors while testing locally in addition to annotation at method level
				registry.addMapping("/setuserapi").allowedOrigins("http://localhost:3000");
				registry.addMapping("/setuserapi2").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
