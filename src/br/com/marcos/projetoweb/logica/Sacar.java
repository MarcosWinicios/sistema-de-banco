package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.dao.ContaDAO;
import br.com.marcos.projetoweb.dao.ContaPoupancaDAO;
import br.com.marcos.projetoweb.model.Conta;
import br.com.marcos.projetoweb.model.ContaCorrente;

public class Sacar implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		Double valorSacar = (Double.parseDouble(req.getParameter("valor")));
		Conta conta = (Conta)session.getAttribute("conta");
		if(conta instanceof ContaCorrente) {
			conta.setSaldo(conta.getSaldo() - (valorSacar * 1.01));
		}
		else {
			conta.setSaldo(conta.getSaldo() - valorSacar);
		}
		ContaDAO cDAO = new ContaDAO();
		cDAO.alterarSaldo(conta);
		
		return null;
	}

}
