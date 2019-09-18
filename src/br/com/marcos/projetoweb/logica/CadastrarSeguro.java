package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.marcos.projetoweb.dao.SeguroDAO;
import br.com.marcos.projetoweb.model.Seguro;

public class CadastrarSeguro implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numero = Integer.parseInt(req.getParameter("numero"));
		int situacao = Integer.parseInt(req.getParameter("situacao"));
		double valor = Double.parseDouble(req.getParameter("valor"));
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		
		Seguro seguro = new Seguro();
		seguro.setNumero(numero);
		seguro.setSituacao(true);
		seguro.setValor(valor);
		
		new SeguroDAO().inserirSeguro(seguro, cliente);
		
		return "texto";
	}

}
