package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.demo")
@EnableCaching
public class InventoryManagementApplication {
	
	private static final Logger logger=LoggerFactory.getLogger(InventoryManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApplication.class, args);
		
		logger.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}

}
