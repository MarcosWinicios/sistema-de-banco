package br.com.marcos.projetoweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import br.com.marcos.projetoweb.conexao.Conexao;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.Conta;
import br.com.marcos.projetoweb.model.Seguro;

public class SeguroDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public SeguroDAO() {
		Conexao conn =  new Conexao();
		this.conexao = conn.getConexao();
	}
	
	public boolean inserirSeguro(Seguro seg, int idCliente) {
		String sql = "INSERT INTO seguro (numero, valor, situacao, idCliente)values (?,?,?,?)";
		
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, seg.getNumero());
			stmt.setDouble(2, seg.getValor());
			stmt.setBoolean(3, seg.getSituacao());
			stmt.setInt(4, idCliente);
			stmt.execute();
			stmt.close();
			return true;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public Seguro pesquisarNumero(int num) {
		String sql = "SELECT * FROM seguro WHERE numero = ?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, num);
			ResultSet rs = this.stmt.executeQuery();
			Seguro seg = new Seguro();
			if(rs.next()) {
				seg = new Seguro(rs.getInt("id"), rs.getInt("numero"), rs.getDouble("valor"), rs.getBoolean("situacao"));
			}
			this.stmt.close();
			return seg;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public Seguro pesquisarIdCliente(Cliente c) {
		String sql = "SELECT * FROM seguro WHERE idCliente = ?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, c.getIdCliente());
			ResultSet rs = this.stmt.executeQuery();
			Seguro seg = new Seguro();
			if(rs.next()) {
				seg = new Seguro(rs.getInt("id"), rs.getInt("numero"), rs.getDouble("valor"), rs.getBoolean("situacao"));
			}
			this.stmt.close();
			return seg;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Seguro pesquisarId(int id) {
		String sql = "SELECT * FROM seguro WHERE id = ?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = this.stmt.executeQuery();
			Seguro seg = new Seguro();
			if(rs.next()) {
				seg = new Seguro(rs.getInt("id"), rs.getInt("numero"), rs.getDouble("valor"), rs.getBoolean("situacao"));
			}
			this.stmt.close();
			return seg;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean alterarSituacao(Seguro seguro) {
		String sql ="UPDATE seguro SET situacao = ? WHERE numero = ?";
		
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, seguro.getSituacao()==true?1:0);
			stmt.setInt(2, seguro.getNumero());
			stmt.execute();
			stmt.close();
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean alterarValor(Seguro seguro) {
		String sql ="UPDATE seguro SET valor = ? WHERE numero = ?";
		
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setDouble(1, seguro.getValor());
			stmt.setInt(2, seguro.getNumero());
			stmt.execute();
			stmt.close();
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean deletar(Seguro seg) {
		String sql = "DELETE FROM seguro WHERE id = ? ";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, seg.getId());
			stmt.execute();
			stmt.close();
			return true;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
