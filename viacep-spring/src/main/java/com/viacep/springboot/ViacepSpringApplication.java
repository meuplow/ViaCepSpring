package com.viacep.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.viacep.springboot.model.Endereco;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ViacepSpringApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ViacepSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ViacepSpringApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Endereco endereco = restTemplate.getForObject("https://viacep.com.br/ws/91787232/json/", Endereco.class);
			System.out.println(endereco.toString());
			
			log.info(endereco.toString());
		};
		
	}

}
