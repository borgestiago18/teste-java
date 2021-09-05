package br.com.confidencecambio.javabasico.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.confidencecambio.javabasico.exception.AlturaException;

@SpringBootTest
public class ImcServiceTest {

	@Autowired
	private ImcService imcService;
    
    @Test
    public void exceptionQuandoAlturaMenorQueZero() {
    	
    	Double altura = (double) 0;
    	Double peso = (double) 10;

    	assertThrows(AlturaException.class, () -> imcService.calcularImc(altura, peso));
    }
    
    @Test
    public void validarValorIMCCalculado() throws AlturaException {
    	
    	Double altura = 1.73;
    	Double peso = 75.0;
    	
    	DecimalFormat decimalFormat = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));
    	assertThat(decimalFormat.format(imcService.calcularImc(altura, peso).getImc())).isEqualTo(String.valueOf(25.06));
    }
}
