package br.com.marcos.projetoweb.model;

public class Relatorio {
	
	public double calcularImposto(Cliente c) {
		double impostos = 0;
		for (Produto p : c.getProdutos()) {
			impostos += p.valorImposto(); 
		}
		return impostos;
	}
	
	public double calcularImposto(Produto p) {
//		System.out.println("Valor do imposto: ");
		return p.valorImposto();
	}
}
