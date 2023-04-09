package com.hiberusTM.priceInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PriceInfoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PriceInfoApplication.class, args);
	}

}
