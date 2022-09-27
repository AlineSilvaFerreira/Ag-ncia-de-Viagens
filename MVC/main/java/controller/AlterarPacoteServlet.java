package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class AlterarPacoteServlet
 */
@WebServlet("/alterarPacote")
public class AlterarPacoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPacote = Integer.parseInt(req.getParameter("id"));
		
		PacoteDAO pdao = new PacoteDAO();
		Pacote pacoteSelecionado = pdao.getPacoteById(idPacote);
		req.setAttribute("pacote", pacoteSelecionado);
	
		RequestDispatcher rd = req.getRequestDispatcher("/AlterarPacote.jsp");

        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pacote pacoteAlterado = new Pacote();
		Hospedagem hospedagem = new Hospedagem();
		Voo voo = new Voo();
		
		pacoteAlterado.setValor(Double.parseDouble(req.getParameter("valor")));
		pacoteAlterado.setDesconto(Integer.parseInt(req.getParameter("desconto")));
		
		pacoteAlterado.setHospedagem(hospedagem);
		pacoteAlterado.getHospedagem().setId(Integer.parseInt(req.getParameter("idHospedagem")));
		
		pacoteAlterado.setVoo(voo);
		pacoteAlterado.getVoo().setId(Integer.parseInt(req.getParameter("idVoo")));
	
		pacoteAlterado.setId(Integer.parseInt(req.getParameter("id")));		
		
		PacoteDAO pd = new PacoteDAO();
		pd.update(pacoteAlterado);	
		resp.sendRedirect("ListarPacote");
	}
}
	