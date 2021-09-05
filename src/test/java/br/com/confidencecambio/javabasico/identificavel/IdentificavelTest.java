package br.com.confidencecambio.javabasico.identificavel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.confidencecambio.javabasico.model.Cliente;
import br.com.confidencecambio.javabasico.model.Gerente;
import br.com.confidencecambio.javabasico.model.Robo;

@SpringBootTest
public class IdentificavelTest {

	private Robo robo;
	private Cliente cliente;
	private Gerente gerente;
	
	@BeforeEach
	public void init() throws Exception {
		this.robo = new Robo("João Soares Silva");
		this.cliente = new Cliente("João Soares Silva");
		this.gerente = new Gerente("João Soares Silva");
	}
	
	@Test
	public void exceptionQuandoNomeNullOuEmBranco() {

		assertThrows(Exception.class, () -> new Gerente(null));
		assertThrows(Exception.class, () -> new Cliente(null));
		assertThrows(Exception.class, () -> new Robo(null));

	}

	@Test
	public void validarObterPrimeiroNome() {
		
		assertThat(robo.obterPrimeiroNome()).isEqualTo("João");
		assertThat(cliente.obterPrimeiroNome()).isEqualTo("João");
		assertThat(gerente.obterPrimeiroNome()).isEqualTo("João");
	}
	
	@Test
	public void validarObterUltimoNome() {
		
		assertThat(robo.obterUltimoNome()).isEqualTo("Soares Silva");
		assertThat(cliente.obterUltimoNome()).isEqualTo("Soares Silva");
		assertThat(gerente.obterUltimoNome()).isEqualTo("Soares Silva");
	}
	
	@Test
	public void validarObterNomeMaisculo() {
		
		assertThat(robo.obterNomeTodoMaisculo()).isEqualTo("JOÃO SOARES SILVA");
		assertThat(cliente.obterNomeTodoMaisculo()).isEqualTo("JOÃO SOARES SILVA");
		assertThat(gerente.obterNomeTodoMaisculo()).isEqualTo("JOÃO SOARES SILVA");
	}
	
	@Test
	public void validarObterNomeAbreviado() {
		
		assertThat(robo.obterNomeAbreviado()).isEqualTo("João S. Silva");
		assertThat(cliente.obterNomeAbreviado()).isEqualTo("João S. Silva");
		assertThat(gerente.obterNomeAbreviado()).isEqualTo("João S. Silva");
	}
	
}
