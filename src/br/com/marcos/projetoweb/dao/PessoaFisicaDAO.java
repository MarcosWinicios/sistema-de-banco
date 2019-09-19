package br.com.marcos.projetoweb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.marcos.projetoweb.conexao.Conexao;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.PessoaFisica;
import br.com.marcos.projetoweb.model.PessoaJuridica;
import br.com.marcos.projetoweb.dao.ClienteDAO;

public class PessoaFisicaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public PessoaFisicaDAO() {
		Conexao conn = new Conexao();
		this.conexao = conn.getConexao();
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
				
				ClienteDAO cDAO = new ClienteDAO();
				pF.setIdCliente(id);;
				pF = (PessoaFisica) cDAO.pesquisarId(pF);
				pF.setCpf(cpF);
				pF.setNomeMae(nomeMae);
				pF.setNomePai(nomePai);
				pF.setIdCliente(id);;
			}
			this.stmt.close();
			return pF;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}	
	} 
	
	public void inserirPf(Cliente c) {
		
		String sql = "INSERT INTO pessoaFisica(cpf, nomeMae, nomePai, idCliente) VALUES (?,?,?,?)";
		try {
			ClienteDAO cDAO = new ClienteDAO();
			PessoaFisica pf =  (PessoaFisica) cDAO.inserir(c);
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, pf.getCpf());
			stmt.setString(2, pf.getNomeMae());
			stmt.setString(3, pf.getNomePai());
			stmt.setInt(4, pf.getIdCliente());
			stmt.execute();
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	public List<PessoaFisica> listarPF() {
		String sql = "select * from pessoaJuridica";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<PessoaFisica> lista = new ArrayList<PessoaFisica>();
			while(rs.next()) {
				Cliente cliente = new ClienteDAO().pesquisarId(cliente);
				PessoaFisica pf = new PessoaFisica(rs.getString("cpf"), 
						rs.getString("nomeMae"), rs.getString("nomePai"), cliente));
				lista.add(pf);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);	
		}
	}
	*/
}
