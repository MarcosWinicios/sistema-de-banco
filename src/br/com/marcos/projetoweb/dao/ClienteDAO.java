package br.com.marcos.projetoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.marcos.projetoweb.conexao.Conexao;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.PessoaFisica;
import br.com.marcos.projetoweb.model.PessoaJuridica;

public class ClienteDAO {
	private Connection conexao;
	private PreparedStatement stmt;

	
	public ClienteDAO() {
		Conexao conn = new Conexao();
		this.conexao = conn.getConexao();
	}
	
	public boolean inserirF(Cliente c) {
		PessoaFisica x = (PessoaFisica) c;

		String sql1 = "INSERT INTO cliente (nome, endereco, telefone, nomePai, nomeMae) VALUES(?,?,?,?,?)";
		String sql2 = "INSERT INTO pessoaFisica(cpf, cliente) VALUES (?,?)";

		try {
			stmt = conexao.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, x.getNome());
			stmt.setString(2, x.getEndereco());
			stmt.setString(3, x.getTelefone());
			stmt.setString(4, x.getNomePai());
			stmt.setString(5, x.getNomeMae());
			stmt.execute();
			
			//Buscar o ID inserido
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			stmt.close();
			stmt = conexao.prepareStatement(sql2);
			//PessoaFisica x = (PessoaFisica) c;
			stmt.setString(1, x.getCpf());
			stmt.setInt(2, rs.getInt(1));
			stmt.execute();
			stmt.close();
			
			return true;
			
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
			stmt.close();
			stmt = conexao.prepareStatement(sql2);
			stmt.setString(1, x.getCnpj());
			stmt.setInt(2, rs.getInt(1));
			stmt.execute();
			stmt.close();
			
			return true;
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public PessoaFisica pesquisarPf(String cpf) {
		String sql = "SELECT * FROM pessoaFisica WHERE cpf = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = this.stmt.executeQuery();
			PessoaFisica  pF = new PessoaFisica();
			if(rs.next()) {
				String cpF = rs.getString("cpf");
				String nomeMae = rs.getString("nomeMae");
				String nomePai = rs.getString("nomePai");
				int id = rs.getInt("idCliente");
				
				pF = (PessoaFisica) this.pesquisarId(id, 1);
				pF.setCpf(cpF);
				pF.setNomeMae(nomeMae);
				pF.setNomePai(nomePai);
			}
			this.stmt.close();
			return pF;
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
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
				pJ = (PessoaJuridica) this.pesquisarId(id, 2);
				pJ.setCnpj(cnpJ);
				pJ.setNomeFantasia(nomeFantasia);
			}
			this.stmt.close();
			return pJ;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cliente pesquisarId(int id, int tipo) {
		String sql ="SELECT * FROM cliente WHERE id = ?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = this.stmt.executeQuery();
			Cliente c =  new PessoaFisica();
			if(tipo == 1) {
				if(rs.next()) {
					c = new PessoaFisica(rs.getInt("id"),rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"));	
				}
				this.stmt.close();
				
				return c;
				
			}else{
				if(rs.next()) {
					c = new PessoaJuridica(rs.getInt("id"),rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"));
				}
				this.stmt.close();
				return c;
			}
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
