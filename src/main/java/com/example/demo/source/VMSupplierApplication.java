package com.example.demo.source;

import com.example.demo.domain.VM;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Supplier;

@SpringBootApplication
public class VMSupplierApplication {

	public static void main(String[] args) {
		SpringApplication.run(VMSupplierApplication.class, args);
	}

	@Bean
	public Supplier<VM> supplier() {
		return () -> new VM(new BigDecimal(-30), "USD", LocalDateTime.now().toString());
	}

}
