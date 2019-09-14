package br.com.marcos.projetoweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.marcos.projetoweb.logica.Logica;

@SuppressWarnings("serial")
@WebServlet("/sistema")
public class ControllerServlet extends HttpServlet {
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parametro = req.getParameter("logica");
		String nomeClasse = "br.com.marcos.projetoweb.logica." + parametro;
		
		try {
			Class<?> classe = Class.forName(nomeClasse);  
			Logica logica = (Logica) classe.getDeclaredConstructor().newInstance(); 
			String pagina = logica.executa(req, resp);
			req.getRequestDispatcher(pagina).forward(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
