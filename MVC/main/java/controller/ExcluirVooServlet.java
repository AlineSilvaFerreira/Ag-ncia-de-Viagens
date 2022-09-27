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
 * Servlet implementation class ExcluirVooServlet
 */
@WebServlet("/ExcluirVoo")
public class ExcluirVooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idVoo = Integer.parseInt(req.getParameter("id"));
		Voo vooExcluido = new Voo();
		vooExcluido.setId(idVoo);

		VooDAO vdao = new VooDAO();

		vdao.deleteById(idVoo);

		resp.sendRedirect("ListarVoo");
	}

}