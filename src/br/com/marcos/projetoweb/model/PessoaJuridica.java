package br.com.marcos.projetoweb.model;

public class PessoaJuridica extends Cliente {
	private int id;
	private String cnpj;
	private String nomeFantasia;
	
	
	public PessoaJuridica() {
		super();
	}
	
	
	
	public PessoaJuridica(int idPj, String cnpj, String nomeFantasia) {
		super();
		this.id = idPj;
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}



	public PessoaJuridica(int id, String nome, String endereco, String telefone) {
		super(id, nome, endereco, telefone);
	}

	public PessoaJuridica(int id, String nome, String endereco, String telefone, String cnpj, String nomeFantasia) {
		super(id, nome, endereco, telefone);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}

	public PessoaJuridica(String nome, String endereco, String telefone, String cnpj, String nomeFantasia) {
		super(nome, endereco, telefone);
		this.setCnpj(cnpj);
		this.setNomeFantasia(nomeFantasia);
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public int getId() {
		return id;
	}

	public void setIdPj(int id) {
		this.id = id;
	}
}
