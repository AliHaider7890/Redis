package com.example.ali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
public class AliApplication {

	public static void main(String[] args) {
		SpringApplication.run(AliApplication.class, args);
	}

}
