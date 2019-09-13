package br.com.marcos.projetoweb.model;

import java.util.List;

public class PessoaFisica extends Cliente {
	private String cpf;
	private String nomeMae;
	private String nomePai;
	
	
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(int id, String nome, String endereco, String telefone) {
		super(id, nome, endereco, telefone);
	}

	public PessoaFisica(int id, String nome, String endereco, String telefone, List<Produto> produtos, String cpf, String nomeMae, String nomePai) {
		super(id, nome, endereco, telefone, produtos);
		this.cpf = cpf;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
	}

	PessoaFisica(String nome, String endereco, String telefone, String cpf) {
		super(nome, endereco, telefone);
		this.setCpf(cpf);
	}
	
	public PessoaFisica(String nome, String endereco, String telefone) {
		super(nome, endereco, telefone);
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
