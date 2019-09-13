package br.com.marcos.projetoweb.model;

import java.util.ArrayList;
import java.util.List;

public class Teste {
	public static void main(String[] args) {
		System.out.println("Testando...");

		PessoaFisica pf = new PessoaFisica("Fulano", "Rua1", "987654321", "111.222.333-44");
		pf.addCCorrente(100);
		pf.addCPoupanca(200);
		pf.addSeguro(300, 5200);

		System.out.println(pf.getProdutos().size());

		Produto p1 = pf.getProdutos().get(0);
		Produto p2 = pf.getProdutos().get(1);
		Produto p3 = pf.getProdutos().get(2);

		Conta c1 = (Conta) p1;
		Conta c2 = (Conta) p2;

		c1.depositar(2000);
		c2.depositar(5000);

//		Porque essa linha não funciona?
//		Conta c3 = (conta) p3;

//		System.out.println("Tipos:");
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);

		System.out.println("Gerando relatório...");

		Relatorio r = new Relatorio();
		System.out.println(r.calcularImposto(p1));
		System.out.println(r.calcularImposto(p2));
		System.out.println(r.calcularImposto(p3));

		System.out.println("Outra forma de gerar relatório...");
		System.out.println(new Relatorio().calcularImposto(pf));

//		Exemplos de código
		List<Produto> prods = new ArrayList<Produto>();
		for (Produto prod : pf.getProdutos()) {
			if (prod instanceof Conta) {
				Conta novaConta = (Conta) prod;
				prods.add(novaConta);
			} else if (prod instanceof Seguro) {
				Seguro novoSeguro = (Seguro) prod;
				prods.add(novoSeguro);
			}
		}
	}
}