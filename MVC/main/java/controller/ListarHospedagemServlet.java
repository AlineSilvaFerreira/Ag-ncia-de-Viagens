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

import model.Hospedagem;
import model.HospedagemDAO;

/**
 * Servlet implementation class ListarHospedagemServlet
 */
@WebServlet("/ListarHospedagem")
public class ListarHospedagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Hospedagem> hospedagem = new ArrayList<Hospedagem>();
		HospedagemDAO hospedagemdao = new HospedagemDAO();
		hospedagem = hospedagemdao.getHospedagem();
		request.setAttribute("listaHospedagem", hospedagem );

		RequestDispatcher dispatcher = request.getRequestDispatcher("CadastroHospedagem.jsp");
		dispatcher.forward(request, response);
		
	}
}