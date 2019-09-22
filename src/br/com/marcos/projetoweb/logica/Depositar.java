package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.dao.ContaDAO;
import br.com.marcos.projetoweb.model.Conta;

public class Depositar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
				
		Double valorDeposito = (Double.parseDouble(req.getParameter("valor")));
		if(valorDeposito > 0) {
			Conta conta = (Conta)session.getAttribute("produto");
			if(conta.getSituacao()) {
				conta.setSaldo(conta.getSaldo() + valorDeposito);
				
				ContaDAO cDAO = new ContaDAO();
				cDAO.alterarSaldo(conta);
		
				return "sucesso.jsp?pagina=conta";
			}
		}
		return "falha.jsp?pagina=conta";
	}

}