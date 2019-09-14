package br.com.marcos.projetoweb.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private int idCliente;
	private String nome;
	private String endereco;
	private String telefone;
	private List<Produto> produtos;
		
	public Cliente() {
		super();
		this.idCliente = 0;
	}

	public Cliente(int id, String nome, String endereco, String telefone) {
		super();
		this.idCliente = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Cliente(int id, String nome, String endereco, String telefone, List<Produto> produtos) {
		this.idCliente = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.produtos = produtos;
	}

	Cliente(String nome, String endereco, String telefone) {
		this.idCliente = 0;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.produtos = new ArrayList<Produto>();
	}

	public void addCCorrente(int numero) {
		ContaCorrente cc = new ContaCorrente(numero);
		this.getProdutos().add(cc);
	}

	public void addCPoupanca(int numero) {
		this.getProdutos().add(new ContaPoupanca(numero));
	}

	public void addSeguro(int numero, double valor) {
		this.getProdutos().add(new Seguro(numero, valor));
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int id) {
		this.idCliente = id;
	}
}
	