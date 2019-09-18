package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.marcos.projetoweb.dao.PessoaFisicaDAO;
import br.com.marcos.projetoweb.model.PessoaFisica;

public class PesquisarCliente implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cpf = req.getParameter("cpf");
		
		PessoaFisica pf = (PessoaFisica) new PessoaFisicaDAO().pesquisarPf(cpf);
		req.setAttribute("pf", pf);
		
		return "/returnCliente";
	}

}
