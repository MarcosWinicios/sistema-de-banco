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
				
				pF = (PessoaFisica) cDAO.pesquisarId(pF);
				pF.setCpf(cpF);
				pF.setNomeMae(nomeMae);
				pF.setNomePai(nomePai);
				pF.setIdCliente(id);;
				cDAO.pesquisarId(pF);
			}
			this.stmt.close();
			return pF;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}	
	} 
	
	
}
