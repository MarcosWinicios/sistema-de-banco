package br.com.marcos.projetoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.marcos.projetoweb.conexao.Conexao;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.PessoaFisica;
import br.com.marcos.projetoweb.model.PessoaJuridica;
import br.com.marcos.projetoweb.dao.ClienteDAO;

public class PessoaJuridicaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public PessoaJuridicaDAO(){
		Conexao conn = new Conexao();
		this.conexao = conn.getConexao();
	}
	
	public PessoaJuridica pesquisarPj(String cnpj) {
		String sql = "SELECT * FROM pessoaJuridica WHERE cnpj = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cnpj);
			ResultSet rs = this.stmt.executeQuery();
			PessoaJuridica pJ = new PessoaJuridica();
			if(rs.next()) {
				String cnpJ = rs.getString("cnpj");
				String nomeFantasia = rs.getString("nomeFantasia");
				int id = rs.getInt("idCliente");
				ClienteDAO cDAO = new ClienteDAO();
				pJ.setIdCliente(id);
				pJ = (PessoaJuridica) cDAO.pesquisarId(pJ);
				pJ.setCnpj(cnpJ);
				pJ.setNomeFantasia(nomeFantasia);
				pJ.setIdCliente(id);
			}
			this.stmt.close();
			return pJ;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void inserir(Cliente c) {
		String sql = "INSERT INTO pessoaJuridica(cnpj, nomeFantasia, idCliente) VALUES (?,?,?)";
		try {
			ClienteDAO cDAO = new ClienteDAO();
			PessoaJuridica pJ =(PessoaJuridica) cDAO.inserir(c);
			stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, pJ.getCnpj());
			stmt.setString(2, pJ.getNomeFantasia());
			stmt.setInt(3, pJ.getIdCliente());
			stmt.execute();
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException(e);
				
			
		}
	}
}
