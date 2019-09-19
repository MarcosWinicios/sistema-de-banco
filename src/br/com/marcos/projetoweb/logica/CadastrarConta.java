package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.marcos.projetoweb.dao.ContaDAO;
import br.com.marcos.projetoweb.model.Conta;
import br.com.marcos.projetoweb.model.ContaCorrente;

public class CadastrarConta implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numero = Integer.parseInt(req.getParameter("numero"));
		double saldo = Double.parseDouble(req.getParameter("saldo"));
//		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		
		Conta contaCorrente = new ContaCorrente(numero);
		contaCorrente.setNumero(numero);
		contaCorrente.setSaldo(saldo);
		
		int idCliente = 6;
		
		new ContaDAO().cadastrar(contaCorrente, idCliente);
		
		return "sucessoCliente.jsp";
	}

}
