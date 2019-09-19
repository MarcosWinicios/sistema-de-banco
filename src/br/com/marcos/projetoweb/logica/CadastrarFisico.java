package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.marcos.projetoweb.dao.PessoaFisicaDAO;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.PessoaFisica;

public class CadastrarFisico implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = req.getParameter("nome");
		String endereco  = req.getParameter("endereco");
		String telefone  = req.getParameter("telefone");
		
		String cpf = req.getParameter("cpf");
		String nomeMae = req.getParameter("nomeMae");
		String nomePai = req.getParameter("nomePai");
		
		Cliente pf = new PessoaFisica(nome, endereco, telefone, cpf,nomeMae, nomePai);
		new PessoaFisicaDAO().inserirPf(pf);
		
		return "index.jsp";
	}

}
