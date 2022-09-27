package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Voo;
import model.VooDAO;

/**
 * Servlet implementation class ListarVooServlet
 */
@WebServlet("/ListarVoo")
public class ListarVooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Voo> voo = new ArrayList<Voo>();
		VooDAO voodao = new VooDAO();
		voo =voodao.getVoo();
		request.setAttribute("listaVoos", voo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("CadastrarVoo.jsp");
		dispatcher.forward(request, response);
		
	}

}
