package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Voo;
import model.VooDAO;

/**
 * Servlet implementation class InserirVooServlet
 */
@WebServlet("/InserirVoo")
public class InserirVooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String origem = request.getParameter("origem");
		String destino = request.getParameter("destino");
		String dataIda = request.getParameter("dataIda");
		String dataVolta = request.getParameter("dataVolta");
				
		Voo voo = new Voo();

		voo.setOrigem(origem);
		voo.setDestino(destino);
		voo.setDataIda(dataIda);
		voo.setDataVolta(dataVolta);
				
		VooDAO vdao = new VooDAO();
		vdao.save(voo);

		response.sendRedirect("ListarVoo");
	}
}