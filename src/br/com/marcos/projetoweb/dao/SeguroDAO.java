package br.com.marcos.projetoweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import br.com.marcos.projetoweb.conexao.Conexao;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.Seguro;

public class SeguroDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public SeguroDAO() {
		Conexao conn =  new Conexao();
		this.conexao = conn.getConexao();
	}
	
	public boolean inserirSeguro(Seguro seg, Cliente c) {
		String sql = "INSERT INTO seguro (numero, valor, situacao, idCliente)values (?,?,?,?)";
		
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, seg.getNumero());
			stmt.setDouble(2, seg.getValor());
			stmt.setBoolean(3, seg.getSituacao());
			stmt.setInt(4, c.getIdCliente());
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

	
	public Seguro pesquisarIdCliente(int id) {
		String sql = "SELECT * FROM seguro WHERE idCliente = ?";
		
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
