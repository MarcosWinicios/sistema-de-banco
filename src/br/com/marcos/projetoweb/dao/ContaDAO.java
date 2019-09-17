package br.com.marcos.projetoweb.dao;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.marcos.projetoweb.conexao.Conexao;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.Conta;
import br.com.marcos.projetoweb.model.ContaCorrente;
import br.com.marcos.projetoweb.model.ContaPoupanca;
import br.com.marcos.projetoweb.model.Produto;

public class ContaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public ContaDAO() {
		Conexao conn = new Conexao();
		this.conexao = conn.getConexao();
	}
	
	public boolean cadastrar(Conta c, int idCliente) {
		String sql = null;
		
		if(c.getTipo() == "pupanca") {
			sql = "INSERT INTO conta (numero, saldo,idCliente,idTipo) values(?,?,?" + 1 + ")";
		}else {
			sql = "INSERT INTO conta (numero, saldo,idCliente,idTipo) values(?,?,?" + 2 + ")";
		}
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, c.getNumero());
			stmt.setDouble(2, c.getSaldo());
			stmt.setInt(3, idCliente);
			stmt.execute();
			stmt.close();
			return true;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Produto> pesquisarIdCliente(Cliente c) {
		String sql = "SELECT *  FROM conta WHERE idCliente = ?";
		
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, c.getIdCliente());
			ResultSet rs = stmt.executeQuery();
			Conta x = null;
			List<Produto> produtos = new ArrayList<Produto>();
			if(rs.next()) {
				x.setId(rs.getInt("id"));
				x.setNumero(rs.getInt("numero"));
				x.setSaldo(rs.getDouble("saldo"));
				if(rs.getInt("situacao") == 1) {
					x.setSituacao(true);
				}else {
					x.setSituacao(false);
				}		
				if(rs.getInt("idTipo") == 1) {
					ContaPoupanca a = (ContaPoupanca) x;
					produtos.add(a);
				}else {
					ContaCorrente a = (ContaCorrente) x;
					produtos.add(a);
				}
				return produtos;
			}else {
				return produtos;
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean sacar_depositar(int numeroConta, double valor) {
		String sql ="UPDATE conta SET saldo = ? WHERE numero = ?";
		
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setDouble(1, valor);
			stmt.setInt(2, numeroConta);
			stmt.execute();
			stmt.close();
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean desativar(int numero) {
		String sql ="UPDATE conta SET situacao = FALSE WHERE numero = ?";
		
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, numero);
			stmt.execute();
			stmt.close();
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean ativar(int numero) {
		String sql ="UPDATE conta SET situacao = TRUE WHERE numero = ?";
				try {
					stmt = this.conexao.prepareStatement(sql);
					stmt.setInt(1, numero);
					stmt.execute();
					stmt.close();
					return true;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
		}
}
