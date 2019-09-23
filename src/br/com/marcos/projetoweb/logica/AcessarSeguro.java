package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.Produto;
import br.com.marcos.projetoweb.model.Seguro;

public class AcessarSeguro implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		int numSeguro = Integer.parseInt(req.getParameter("numSeguro"));
		Cliente cliente = (Cliente)session.getAttribute("cliente");
		
		for(Produto p : cliente.getProdutos()) {
			if(p instanceof Seguro) {
				Seguro seguro = (Seguro)p;
				if(seguro.getNumero() == numSeguro) {
					session.setAttribute("produto", seguro);
					return "seguro.jsp";
				}
			}
		}
		return "falha.jsp?pagina=cliente";
		
	}
	
}
