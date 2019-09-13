package br.com.marcos.projetoweb.model;

public abstract class Conta implements Produto {
	private int id;
	private int numero;
	private double saldo;
	private boolean situacao;


	public Conta() {
		super();
	}

	Conta(int numero) {
		this.numero = numero;
		this.saldo = 0;
		this.situacao = true;
	}

	public boolean sacar(double valor) {
		if (valor <= this.getSaldo()) {
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}
	}

	public boolean depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			return true;
		} else {
			return false;
		}
	}

	public void desativar() {
		this.situacao = false;
	}

	public void ativar() {
		this.situacao = true;
	}

	public double getSaldo() {
		return saldo;
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

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}