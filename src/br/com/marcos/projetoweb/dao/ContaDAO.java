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
		
		if(c instanceof ContaPoupanca) {
			sql = "INSERT INTO conta (numero, saldo,situacao,idCliente,idTipoConta) values(?,?,1,?,1 )";
		}else {
			sql = "INSERT INTO conta (numero, saldo,situacao,idCliente,idTipoConta) values(?,?,1,?,2)";
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
	
	public Conta pesquisarNumero(int numero) {
		String sql = "SELECT * FROM conta WHERE numero = ?";
		
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, numero);
			ResultSet rs = stmt.executeQuery();
			Conta conta = new ContaPoupanca();
			if(rs.next()) {
				if(rs.getInt("idTipoConta") == 2) {
					conta = new ContaPoupanca();
					conta.setNumero(rs.getInt("numero"));
				}
				else{
					conta = new ContaCorrente(rs.getInt("numero"));
				}
				conta.setId(rs.getInt("id"));
				conta.setSaldo(rs.getDouble("saldo"));
				if(rs.getInt("situacao") == 1) {
					conta.setSituacao(true);
				}else {
					conta.setSituacao(false);
				}
			}	
			return conta;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Produto> pesquisarIdCliente(Cliente c) {
		String sql = "SELECT *  FROM conta WHERE idCliente = ?";
		
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, c.getIdCliente());
			ResultSet rs = stmt.executeQuery();
			ArrayList<Produto> produtos = new ArrayList<Produto>();
			if(rs.next()) {
				Conta a;
				if(rs.getInt("idTipoConta") == 1) {
					a = new ContaCorrente(rs.getInt("numero"));
					a.setId(rs.getInt("id"));
					a.setNumero(rs.getInt("numero"));
					a.setSaldo(rs.getDouble("saldo"));
					if(rs.getInt("situacao") == 1) {
						a.setSituacao(true);
					}else {
						a.setSituacao(false);
					}		
					produtos.add(a);
				}else if(rs.getInt("idTipoConta") == 2){
					a = new ContaPoupanca() ;
					a.setId(rs.getInt("id"));
					a.setSaldo(rs.getDouble("saldo"));
					if(rs.getInt("situacao") == 1) {
						a.setSituacao(true);
					}else {
						a.setSituacao(false);
					}		
					produtos.add(a);
				}
			
			}
				return produtos;
	
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean alterarSaldo(Conta conta) {
		String sql ="UPDATE conta SET saldo = ? WHERE numero = ?";
		
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setDouble(1, conta.getSaldo());
			stmt.setInt(2, conta.getNumero());
			stmt.execute();
			stmt.close();
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean alterarSituacao(Conta conta) {
		String sql ="UPDATE conta SET situacao = ? WHERE numero = ?";
		
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setBoolean(1, conta.getSituacao());
			stmt.setInt(2, conta.getNumero());
			stmt.execute();
			stmt.close();
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
