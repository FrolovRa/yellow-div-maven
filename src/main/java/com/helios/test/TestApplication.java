package com.helios.test;

import com.helios.test.model.Constant;
import com.helios.test.repository.ConstantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(ConstantRepository repository) {
		return (args) -> {
			repository.save(new Constant(3));
		};
	}

}
