package br.com.marcos.projetoweb.logica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.marcos.projetoweb.dao.PessoaFisicaDAO;
import br.com.marcos.projetoweb.model.PessoaFisica;

public class ListarPF implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PessoaFisica> lista = new PessoaFisicaDAO().listarTudo();
		
		req.setAttribute("lsita", lista);
		
		return "/listaPF.jsp";
	}
	
	

}
