package br.com.marcos.projetoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.marcos.projetoweb.conexao.Conexao;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.PessoaFisica;
import br.com.marcos.projetoweb.model.PessoaJuridica;
import br.com.marcos.projetoweb.model.Produto;

public class ClienteDAO {
	private Connection conexao;
	private PreparedStatement stmt;

	
	public ClienteDAO() {
		Conexao conn = new Conexao();
		this.conexao = conn.getConexao();
	}
	
	public Cliente inserir(Cliente c) {
		String sql = "INSERT INTO cliente (nome, endereco, telefone, nomePai, nomeMae) VALUES(?,?,?,?,?)";

		try {
			stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEndereco());
			stmt.setString(3, c.getTelefone());
			stmt.execute();
			//Buscar o ID inserido
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			c.setIdCliente(rs.getInt(1));	
			stmt.close();
			return c;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean inserirJ(Cliente c) {
		PessoaJuridica x = (PessoaJuridica) c;

		String sql1 = "INSERT INTO cliente (nome, endereco, telefone) VALUES(?,?,?)";
		String sql2 = "INSERT INTO pessoaFisica(cnpj, cliente) VALUES (?,?)";

		try {
			stmt = conexao.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, x.getNome());
			stmt.setString(2, x.getEndereco());
			stmt.setString(3, x.getTelefone());
			stmt.execute();
			
			//Buscar o ultimo ID inserido
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			
			
			return true;
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/*public PessoaJuridica pesquisarPj(PessoaJuridica pj) {
		String sql = "SELECT * FROM pessoaJuridica WHERE cnpj = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, pj.getCnpj());
			ResultSet rs = this.stmt.executeQuery();
			PessoaJuridica pJ = new PessoaJuridica();
			if(rs.next()) {
				String cnpJ = rs.getString("cnpj");
				String nomeFantasia = rs.getString("nomeFantasia");
				int id = rs.getInt("idCliente");
				pJ = (PessoaJuridica) this.pesquisarId(id, 2);
				pJ.setCnpj(cnpJ);
				pJ.setNomeFantasia(nomeFantasia);
			}
			this.stmt.close();
			return pJ;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}*/
		
	public Cliente pesquisarId(Cliente cliente) {
		String sql ="SELECT * FROM cliente WHERE id = ?";	
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cliente.getIdCliente());
			ResultSet rs = this.stmt.executeQuery();
				if(rs.next()) {
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setNome(rs.getString("nome"));
					cliente.setTelefone(rs.getString("telefone"));
				}
				this.stmt.close();	
				return cliente;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}

