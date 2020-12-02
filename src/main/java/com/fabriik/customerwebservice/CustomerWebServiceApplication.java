package com.fabriik.customerwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CustomerWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerWebServiceApplication.class, args);
	}

}
