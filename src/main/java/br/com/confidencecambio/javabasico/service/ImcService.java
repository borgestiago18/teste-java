package br.com.confidencecambio.javabasico.service;

import org.springframework.stereotype.Service;

import br.com.confidencecambio.javabasico.dto.ResultadoImcDTO;
import br.com.confidencecambio.javabasico.exception.AlturaException;

@Service
public class ImcService {

	public ResultadoImcDTO calcularImc(Double altura, Double peso) throws AlturaException {
		
		if(altura <= 0) {
			throw new AlturaException();
		}
		
		Double imc = peso / (altura * altura);
		
		ResultadoImcDTO resultadoIMC = new ResultadoImcDTO();
		resultadoIMC.setAltura(altura);
		resultadoIMC.setPeso(peso);
		resultadoIMC.setImc(imc);
		
		return resultadoIMC;
	}
	
}
