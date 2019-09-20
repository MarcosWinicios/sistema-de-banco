package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.dao.SeguroDAO;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.Seguro;

public class CadastrarSeguro implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Cliente c = (Cliente) session.getAttribute("cliente");
		
		int numero = Integer.parseInt(req.getParameter("numApolice"));
		double valor = Double.parseDouble(req.getParameter("valorSeguro"));
		
		int idCliente = c.getIdCliente();
		
		Seguro seguro = new Seguro();
		seguro.setNumero(numero);
		seguro.setSituacao(true);
		seguro.setValor(valor);
		
		new SeguroDAO().inserirSeguro(seguro, idCliente);
		
		return "index.jsp";
	}

}
