package com.example.demo.sink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class VMAlertLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(VMAlertLogApplication.class, args);
	}

	@Bean
	public Consumer<String> alertLog() {
	    return System.out::println;
	}

}
