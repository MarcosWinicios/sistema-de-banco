package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.dao.ContaDAO;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.Conta;
import br.com.marcos.projetoweb.model.ContaCorrente;
import br.com.marcos.projetoweb.model.ContaPoupanca;

public class CadastrarConta implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		
		int numero = (Integer.parseInt(req.getParameter("numConta")));
		
		String tipoConta  = req.getParameter("tipoConta");
		
		Conta c;
		int idCliente = cliente.getIdCliente();

		if(tipoConta.equals("poupanca")) {
			c = new ContaPoupanca();
			c.setNumero(numero);
		} else {
			c = new ContaCorrente(numero);
		}
		if(!new ContaDAO().pesquisarNumero(c.getNumero())) {
			new ContaDAO().cadastrar(c, idCliente);
			return "sucesso.jsp?pagina=cliente";
		}
		return "falha.jsp?pagina=cliente";
	}

}
