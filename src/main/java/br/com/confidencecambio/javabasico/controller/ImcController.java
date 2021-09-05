package br.com.confidencecambio.javabasico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.dto.ResultadoImcDTO;
import br.com.confidencecambio.javabasico.exception.AlturaException;
import br.com.confidencecambio.javabasico.service.ImcService;

@RestController
@RequestMapping("/v1/imc")
public class ImcController {

	@Autowired
	private ImcService imcService;
	
	@GetMapping
	public ResultadoImcDTO calcularIMC(@RequestParam(name = "altura", required = true) Double altura, 
									  @RequestParam(name="peso", required=true) Double peso) throws AlturaException {
		
		return imcService.calcularImc(altura, peso);
	}
}
