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
 * Servlet implementation class EscluirHospedagemServlet
 */
@WebServlet("/excluirHospedagem")
public class ExcluirHospedagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idHospedagem = Integer.parseInt(req.getParameter("id"));
		Hospedagem hospedagemExcluida = new Hospedagem();
		hospedagemExcluida.setId(idHospedagem);

		HospedagemDAO hdao = new HospedagemDAO();

		hdao.deleteById(idHospedagem);

		resp.sendRedirect("ListarHospedagem");
	}

}
