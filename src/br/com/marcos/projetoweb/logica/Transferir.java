package br.com.marcos.projetoweb.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marcos.projetoweb.dao.ClienteDAO;
import br.com.marcos.projetoweb.dao.ContaDAO;
import br.com.marcos.projetoweb.model.Cliente;
import br.com.marcos.projetoweb.model.Conta;

public class Transferir implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Cliente cliente = (Cliente)session.getAttribute("cliente");
		
		ContaDAO cDAO = new ContaDAO();
		
		Double valorTransferir = (Double.parseDouble(req.getParameter("valor")));
		if(valorTransferir > 0) {
			Conta contaDestinatario = cDAO.pesquisarNumero(Integer.parseInt(req.getParameter("numConta")));
			Conta contaRemetente = (Conta)session.getAttribute("produto");
			if(contaDestinatario.getSituacao() && contaRemetente.getSituacao()) {
				contaRemetente.setSaldo(contaRemetente.getSaldo() - valorTransferir);
				contaDestinatario.setSaldo(contaDestinatario.getSaldo() + valorTransferir);
				
				cDAO.alterarSaldo(contaRemetente);
				cDAO.alterarSaldo(contaDestinatario);
				
				cliente = new ClienteDAO().pesquisarId(cliente);
				session.setAttribute("cliente", cliente);
				return "sucesso.jsp?pagina=conta";
			}
		}
		return "falha.jsp?pagina=conta";
	}
}
