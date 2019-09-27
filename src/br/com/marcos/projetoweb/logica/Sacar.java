package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.dao.ContaDAO;
import br.com.marcos.projetoweb.model.Conta;
import br.com.marcos.projetoweb.model.ContaCorrente;

public class Sacar implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		Double valorSacar = (Double.parseDouble(req.getParameter("valor")));
		if(valorSacar > 0) {
			Conta conta = (Conta)session.getAttribute("produto");
			if(conta.getSituacao()) {
				if(conta instanceof ContaCorrente) {
					if(conta.getSaldo() > valorSacar) {
						conta.setSaldo(conta.getSaldo() - (valorSacar * 1.01));
					}else {
						return "falha.jsp?pagina=conta";
					}
				}
				else {
					if(conta.getSaldo() > valorSacar) {
						conta.setSaldo(conta.getSaldo() - valorSacar);
					}else {
						return "falha.jsp?pagina=conta";
					}
				}
				ContaDAO cDAO = new ContaDAO();
				cDAO.alterarSaldo(conta);
				
				return "sucesso.jsp?pagina=conta";
			}
		}
		return "falha.jsp?pagina=conta";
	}

}
