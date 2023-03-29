package com.example.msgtry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class MsgtryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgtryApplication.class, args);
	}

}
