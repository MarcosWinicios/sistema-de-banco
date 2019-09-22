package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.ContaCorrente;
import br.com.marcos.projetoweb.model.ContaPoupanca;
import br.com.marcos.projetoweb.model.Produto;

public class AcessarConta implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		int numConta = Integer.parseInt(req.getParameter("numConta"));
		Cliente cliente = (Cliente)session.getAttribute("cliente");
		
		for(Produto p : cliente.getProdutos()) {
			if(p instanceof ContaCorrente) {
				ContaCorrente contaC = (ContaCorrente)p;
				if(contaC.getNumero() == numConta) {
					session.setAttribute("produto", contaC);
					return "conta.jsp";
				}
			}
			else if(p instanceof ContaPoupanca) {
				ContaPoupanca contaP = (ContaPoupanca)p;
				if(contaP.getNumero() == numConta) {
					session.setAttribute("produto", contaP);
					return "conta.jsp";
				}
			}
		}
		return "falha.jsp?pagina=cliente";
		
	}
	
}
