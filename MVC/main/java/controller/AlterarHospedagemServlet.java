package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hospedagem;
import model.HospedagemDAO;
/**
 * Servlet implementation class AlterarHospedagemServlet
 */
@WebServlet("/alterarHospedagem")
public class AlterarHospedagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idHospedagem = Integer.parseInt(req.getParameter("id"));
		HospedagemDAO hdao = new HospedagemDAO();
		Hospedagem hospedagemSelecionada = hdao.getHospedagemById(idHospedagem);

		req.setAttribute("hospedagem", hospedagemSelecionada);
	
		RequestDispatcher rd = req.getRequestDispatcher("/AlterarHospedagem.jsp");

        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Hospedagem hospedagemAlterada = new Hospedagem();
		
		hospedagemAlterada.setDiarias(Integer.parseInt(req.getParameter("diarias")));
		hospedagemAlterada.setIncluso(req.getParameter("incluso"));
		hospedagemAlterada.setId(Integer.parseInt(req.getParameter("id")));
		
		HospedagemDAO hd = new HospedagemDAO();
		hd.update(hospedagemAlterada);	
		resp.sendRedirect("ListarHospedagem");
	}
}
