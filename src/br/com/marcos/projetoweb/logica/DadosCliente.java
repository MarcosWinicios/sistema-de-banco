package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.PessoaFisica;
import br.com.marcos.projetoweb.model.PessoaJuridica;

public class DadosCliente implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Cliente cliente = (Cliente)session.getAttribute("cliente");
		
		
		if( cliente instanceof PessoaFisica) {
			return "dadosPF.jsp";
		}
		else if(cliente instanceof PessoaJuridica){
			return "dadosPJ.jsp";
		}
		return null;
	}

}