package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.dao.PessoaJuridicaDAO;
import br.com.marcos.projetoweb.model.PessoaJuridica;


public class AcessarPJ implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String cnpj = req.getParameter("cnpj");
		PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO(); 
		
		PessoaJuridica pj = pjDAO.pesquisarPj(cnpj);
		if(pj.getId() != 0) {
			session.setAttribute("cliente", pj);			
			return "cliente.jsp";
		}
		return "falha.jsp?pagina=index";
	}
}
