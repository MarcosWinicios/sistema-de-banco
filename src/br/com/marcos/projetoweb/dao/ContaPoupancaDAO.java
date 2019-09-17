package br.com.marcos.projetoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.marcos.projetoweb.conexao.Conexao;

public class ContaPoupancaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public ContaPoupancaDAO() {
		Conexao conn = new Conexao();
		this.conexao = conn.getConexao();
	}
}
