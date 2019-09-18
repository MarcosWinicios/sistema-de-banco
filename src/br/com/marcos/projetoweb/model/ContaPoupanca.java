package br.com.marcos.projetoweb.model;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(){
		super();
	}
	
	ContaPoupanca(int numero) {
		super(numero);
	}

	@Override
	public double valorImposto() {
		return this.getSaldo() * 0.01;
	}

	@Override
	public String getTipo() {
		return "poupanca";
	}

}
