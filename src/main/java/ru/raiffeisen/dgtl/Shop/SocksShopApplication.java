package ru.raiffeisen.dgtl.Shop;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SocksShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocksShopApplication.class, args);
	}

	@Bean("visitorMapper")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
