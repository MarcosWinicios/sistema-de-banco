package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.dao.ContaDAO;
import br.com.marcos.projetoweb.dao.ContaPoupancaDAO;

public class SacarCP implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		Double valorSacar = (Double.parseDouble(req.getParameter("valor")));
		
		
		
		
		ContaDAO cDAO = new ContaDAO();
		cDAO.alterarSaldo(numeroConta, valor);
		
		return null;
	}

}
