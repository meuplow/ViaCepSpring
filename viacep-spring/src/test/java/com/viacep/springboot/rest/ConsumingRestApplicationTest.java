package com.viacep.springboot.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
public class ConsumingRestApplicationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void shouldReturnCepFromJson() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/endereco/91787232"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(content()
				.json("Endereco: [cep=91787-222,"
						+ " logradouro=Rua Rodi Avila Medeiros, "
						+ "complemento=, "
						+ "bairro=Hípica, "
						+ "localidade=Porto Alegre, "
						+ "uf=RS, "
						+ "ibge=4314902, "
						+ "gia=, "
						+ "ddd=51, "
						+ "siafi=8801]"));
	}
	
}
