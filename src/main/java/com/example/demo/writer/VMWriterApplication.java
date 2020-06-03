package com.example.demo.writer;

import com.example.demo.domain.VM;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class VMWriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(VMWriterApplication.class, args);
	}

	@Bean
	public Consumer<VM> write() {
	    return System.out::println;
	}

}
