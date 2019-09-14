package br.com.marcos.projetoweb.logica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.marcos.projetoweb.dao.ClienteDAO;
import br.com.marcos.projetoweb.model.PessoaJuridica;

public class ListarPJ implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PessoaJuridica> lista = new ClienteDAO().listarPJ();
		
		req.setAttribute("lista", lista);
		
		return "/listaPJ.jsp";
	}

}
