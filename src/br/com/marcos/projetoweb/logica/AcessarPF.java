package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.dao.PessoaFisicaDAO;
import br.com.marcos.projetoweb.model.PessoaFisica;

public class AcessarPF implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		String cpf = req.getParameter("cpf");
		
		PessoaFisica pf = new PessoaFisicaDAO().pesquisarPf(cpf);
		if(pf.getId() != 0) {			
			session.setAttribute("cliente", pf);
			return "cliente.jsp";
		}
		return "falha.jsp?pagina=index";
	}

}
