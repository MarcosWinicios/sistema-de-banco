package br.com.marcos.projetoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.marcos.projetoweb.conexao.Conexao;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.Conta;
import br.com.marcos.projetoweb.model.ContaCorrente;
import br.com.marcos.projetoweb.model.ContaPoupanca;
import br.com.marcos.projetoweb.model.Produto;
import br.com.marcos.projetoweb.model.Seguro;

public class ClienteDAO {
	private Connection conexao;
	private PreparedStatement stmt;

	
	public ClienteDAO() {
		Conexao conn = new Conexao();
		this.conexao = conn.getConexao();
	}
	
	public Cliente inserir(Cliente c) {
		String sql = "INSERT INTO cliente (nome, endereco, telefone) VALUES(?,?,?)";

		try {
			stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEndereco());
			stmt.setString(3, c.getTelefone());
			stmt.execute();
			//Buscar o ID inserido
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				c.setIdCliente(rs.getInt(1));
			}
			
			stmt.close();
			return c;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	public Cliente pesquisarId(Cliente cliente) {
		String sql ="SELECT * FROM cliente WHERE id = ?";	
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cliente.getIdCliente());
			ResultSet rs = this.stmt.executeQuery();
			List<Produto> produtos = new ArrayList<Produto>();
				if(rs.next()) {
					cliente.setIdCliente(rs.getInt("id"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setNome(rs.getString("nome"));
					cliente.setTelefone(rs.getString("telefone"));
					produtos = new ContaDAO().pesquisarIdCliente(cliente);
					Seguro seg = new SeguroDAO().pesquisarIdCliente(cliente);
					produtos.add(seg);
					cliente.setProdutos(produtos);
				}
				this.stmt.close();	
				return cliente;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void addSeguro(Seguro s, Cliente c) {
		try {
			SeguroDAO sDAO = new SeguroDAO();
			sDAO.inserirSeguro(s, c.getIdCliente());	
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean addContaPoupanca(Conta conta, Cliente cliente) {
			conta = (ContaPoupanca) conta;
			String sql = "INSERT INTO Conta (numero, saldo, situacao, idCliente, idTipoConta) VALUES(?,?,1,?, 1)";
			try {
				stmt = this.conexao.prepareStatement(sql);
				stmt.setInt(1, conta.getNumero());
				stmt.setDouble(2, conta.getSaldo());
				stmt.setInt(3, cliente.getIdCliente());
				return true;
			}catch(Exception e) {
				throw new RuntimeException();
			}
		}
	
	public boolean addContaCorrente( Conta conta, Cliente cliente) {
		conta = (ContaCorrente) conta;
		String sql = "INSERT INTO Conta (numero, saldo, situacao, idCliente, idTipoConta) VALUES(?,?,1,?, 2)";
		try {
			stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getNumero());
			stmt.setDouble(2, conta.getSaldo());
			stmt.setInt(3, cliente.getIdCliente());
			return true;
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
}

