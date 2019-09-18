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
//		int situacao = Integer.parseInt(req.getParameter("situacao"));
		double saldo = Double.parseDouble(req.getParameter("saldo"));
//		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		
		Conta contaCorrente = new ContaCorrente();
		contaCorrente.setNumero(numero);
		contaCorrente.setSituacao(true);
		contaCorrente.setSaldo(saldo);
		int idCliente = 1;
		
		new ContaDAO().cadastrar(contaCorrente, idCliente);
		
		return "sucessoCliente.jsp";
	}

}
