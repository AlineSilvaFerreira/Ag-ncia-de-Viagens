package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hospedagem;
import model.Pacote;
import model.PacoteDAO;
import model.Voo;

/**
 * Servlet implementation class InserirHospedagemServlet
 */
@WebServlet("/InserirPacote")
public class InserirPacoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double valor = Double.parseDouble(request.getParameter("valor"));
		int desconto = Integer.parseInt(request.getParameter("desconto"));	
		int idHospedagem = Integer.parseInt(request.getParameter("idHospedagem"));	
		int idVoo = Integer.parseInt(request.getParameter("idVoo"));	

		Pacote pacote = new Pacote();
		Hospedagem hospedagem = new Hospedagem();
		Voo voo = new Voo();

		pacote.setValor(valor);
		pacote.setDesconto(desconto);	
		pacote.setHospedagem(hospedagem);
		pacote.getHospedagem().setId(idHospedagem);
		pacote.setVoo(voo);
		pacote.getVoo().setId(idVoo);

		PacoteDAO pdao = new PacoteDAO();
		pdao.save(pacote);

		response.sendRedirect("ListarPacote");
	}
}
