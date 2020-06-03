package com.example.demo.processor;

import com.example.demo.domain.VM;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

@SpringBootApplication
public class VMAccumulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(VMAccumulatorApplication.class, args);
	}

	private static final List<VM> accumulation = new CopyOnWriteArrayList<>(new VM[] {new VM(new BigDecimal(1000), "USD", LocalDateTime.now().toString())});

	@Bean
	public Function<VM, String> accumulate() {
		return vm -> {
			accumulation.add(vm);
			BigDecimal accumulatedVM = accumulation.stream()
					.map(VM::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
			return String.format("Account Alert: %b, accumulatedVM: %s", accumulatedVM.compareTo(BigDecimal.ZERO) < 0, accumulatedVM);
		};
	}

}
