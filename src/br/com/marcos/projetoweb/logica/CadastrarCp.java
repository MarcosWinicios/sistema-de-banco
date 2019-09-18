package br.com.marcos.projetoweb.logica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.marcos.projetoweb.dao.ClienteDAO;
import br.com.marcos.projetoweb.dao.ContaDAO;
import br.com.marcos.projetoweb.model.Conta;
import br.com.marcos.projetoweb.model.ContaPoupanca;
import br.com.marcos.projetoweb.model.PessoaJuridica;

public class CadastrarCp implements Logica {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numero = (Integer.parseInt(req.getParameter("numero")));
		double saldo = (Double.parseDouble(req.getParameter("saldo")));
		
		Conta c = new ContaPoupanca();
		c.setNumero(numero);
		c.setSaldo(saldo);
		new ContaDAO().cadastrar(c, idCliente);
		return "/listaPJ.jsp";
	}
}
