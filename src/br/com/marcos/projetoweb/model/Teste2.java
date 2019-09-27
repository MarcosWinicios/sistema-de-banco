package br.com.marcos.projetoweb.model;

import br.com.marcos.projetoweb.dao.ContaDAO;

public class Teste2 {

	public static void main(String[] args) {
		ContaDAO cDAO = new ContaDAO();
		
		Double valorTransferir = 500.00;
		Conta contaDestinatario = cDAO.pesquisarNumero(2222);
		Conta contaRemetente = cDAO.pesquisarNumero(1111);

		contaDestinatario.setSituacao(true);
		cDAO.alterarSituacao(contaDestinatario);
		
		
		
		//System.out.println(cDAO.pesquisarNumero(1111).getSaldo());
	}

}
