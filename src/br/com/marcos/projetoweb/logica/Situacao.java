package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.dao.ContaDAO;
import br.com.marcos.projetoweb.dao.SeguroDAO;
import br.com.marcos.projetoweb.model.Conta;
import br.com.marcos.projetoweb.model.Produto;
import br.com.marcos.projetoweb.model.Seguro;

public class Situacao implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String opcao = req.getParameter("opcao");

		Produto produto = (Produto)session.getAttribute("produto");
		if(!opcao.equals("cancelar")) {
			if(produto instanceof Conta) {
				ContaDAO cDAO = new ContaDAO();
				Conta conta = (Conta) produto;
				if(opcao.equals("ativar")) {
					conta.setSituacao(true);
				}
				else if (opcao.equals("desativar")){
					conta.setSituacao(false);
				}
				cDAO.alterarSituacao(conta);
				return "sucesso.jsp?pagina=conta";
			}
			else if(produto instanceof Seguro) {
				SeguroDAO sDAO = new SeguroDAO();
				Seguro seguro = (Seguro) produto;
				if(opcao.equals("ativar")) {
					seguro.setSituacao(true);				
				}
				else if (opcao.equals("desativar")){
					seguro.setSituacao(false);	
				}
				sDAO.alterarSituacao(seguro);
				return "sucesso.jsp?pagina=seguro";
			}
		}
		if(produto instanceof Conta) {
			return "conta.jsp";
		}
		else {
			return "seguro.jsp";
		}

	}

}