package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pacote;
import model.PacoteDAO;

/**
 * Servlet implementation class ExcluirPacoteServlet
 */
@WebServlet("/excluirPacote")
public class ExcluirPacoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPacote = Integer.parseInt(req.getParameter("id"));
		Pacote pacoteExcluido = new Pacote();
		pacoteExcluido.setId(idPacote);

		PacoteDAO pdao = new PacoteDAO();

		pdao.deleteById(idPacote);

		resp.sendRedirect("ListarPacote");
	}

}
