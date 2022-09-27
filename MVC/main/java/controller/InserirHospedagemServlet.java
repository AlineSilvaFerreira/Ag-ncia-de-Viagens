package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hospedagem;
import model.HospedagemDAO;

/**
 * Servlet implementation class InserirHospedagemServlet
 */
@WebServlet("/InserirHospedagem")
public class InserirHospedagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int diarias = Integer.parseInt(request.getParameter("diarias"));
		String incluso = request.getParameter("incluso");		

		Hospedagem hospedagem = new Hospedagem();

		hospedagem.setDiarias(diarias);
		hospedagem.setIncluso(incluso);	

		HospedagemDAO idao = new HospedagemDAO();
		idao.save(hospedagem);

		response.sendRedirect("ListarHospedagem");
	}
}