/**
 * Direitos Autorais, 2021, Gabriel Menin.
 */
package com.viacep.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.viacep.springboot.model.Endereco;

/**
 * @author Gabriel
 *
 */

@RestController
@RequestMapping("/api/endereco")
public class ConsumingRestApplication {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/{cep}", method = RequestMethod.GET, produces = "application/json")
	public String getEndereco(@PathVariable String cep) {
		Endereco endereco = restTemplate
				.getForObject("https://viacep.com.br/ws/" + cep + "/json/", Endereco.class);
		return endereco.toString();
	}
}
