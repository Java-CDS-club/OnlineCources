package com.oc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.oc")
public class OnlineCourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCourcesApplication.class, args);
	}
}
