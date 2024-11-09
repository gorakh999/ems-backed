package com.gorakhcodes.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsBackendParentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendParentApplication.class, args);
		System.out.println("EMS backend Running...");
	}

}
