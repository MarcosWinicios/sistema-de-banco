package br.com.marcos.projetoweb.model;

public class Seguro implements Produto {
	private int id;
	private int numero;
	private double valor;
	private boolean situacao;
	
	
	
	public Seguro(int id, int numero, double valor, boolean situacao) {
		super();
		this.id = id;
		this.numero = numero;
		this.valor = valor;
		this.situacao = situacao;
	}

	Seguro(int id, int numero, double valor){
		this.id = id;
		this.numero = numero;
		this.valor = valor;
		this.situacao = true;
	}

	Seguro(int numero, double valor) {
		this.numero = numero;
		this.valor = valor;
		this.situacao = true;
	}
	public Seguro(){
		this.situacao = true;
	}

	@Override
	public double valorImposto() {
		return (this.getValor() * 0.03) + 50;
	}


	@Override
	public String getTipo() {
		return "seguro";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValor() {
		return valor;
	}
	
}