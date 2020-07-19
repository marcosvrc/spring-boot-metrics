package br.com.poc.springbootmetrics;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootmetricsApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmetricsApplication.class, args);
	}

}
