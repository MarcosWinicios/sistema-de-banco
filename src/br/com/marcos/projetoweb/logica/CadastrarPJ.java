package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.marcos.projetoweb.dao.PessoaJuridicaDAO;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.PessoaJuridica;

public class CadastrarPJ implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String endereco  = req.getParameter("endereco");
		String telefone  = req.getParameter("telefone");
		
		String cnpj = req.getParameter("cnpj");
		String nomeFantasia = req.getParameter("nomeFantasia");
		
		Cliente pj = new PessoaJuridica(nome, endereco, telefone, cnpj, nomeFantasia);
		if(new PessoaJuridicaDAO().pesquisarPj(cnpj).getId() == 0) {
			new PessoaJuridicaDAO().inserir(pj);	
			return "sucesso.jsp?pagina=manterCcliente";
		}
		return "falha.jsp?pagina=manterCliente";
	}
	
}
