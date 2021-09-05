package br.com.confidencecambio.javabasico.model;

public abstract class Identificavel {
	
	private String nome;
	
	public Identificavel(String nome) throws Exception {
		
		if(nome == null || nome.isBlank()) {
			throw new NullPointerException();
		}
		this.nome = nome.trim();				
	}
	
	public String obterPrimeiroNome() {
		return this.nome.split(" ")[0];
	}
	
	public String obterUltimoNome() {
		String[] nomes = this.nome.split(" ");
		String ultimoNome = "";
		
		if(nomes.length == 1) {
			ultimoNome = nomes[0];
		}
		else {
			for(int i = 1; i < nomes.length; i++) {
				ultimoNome += nomes[i] + " ";
			}
		}
		return ultimoNome.trim();
	}
	
	public String obterNomeTodoMaisculo() {
		return this.nome.toUpperCase();
	}
	
	public String obterNomeAbreviado() {
		
		String nomeAbreviado = "";
		String[] nomes = this.nome.split(" ");
		int tamanhoNome = nome.split(" ").length;
		
		for(int i = 0; i < tamanhoNome; i++) {
			if(i == 0 || i == tamanhoNome - 1) {
				nomeAbreviado += nomes[i] + " ";
			}
			else {
				nomeAbreviado += nomes[i].toUpperCase().charAt(0) + ". ";
			}
		}
		
		return nomeAbreviado.trim();
	}
	
}
