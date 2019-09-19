package br.com.marcos.projetoweb.model;

public class Teste2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Cliente pj = new PessoaJuridica();
	
		pj = (PessoaJuridica) pj;
		System.out.println(pj.getNome());
		
	}

}
