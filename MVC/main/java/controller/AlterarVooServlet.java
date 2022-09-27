package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Voo;
import model.VooDAO;

/**
 * Servlet implementation class AlterarVooServlet
 */
@WebServlet("/alterarVoo")
public class AlterarVooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idVoo = Integer.parseInt(req.getParameter("id"));
		VooDAO vdao = new VooDAO();
		Voo vooSelecionado = vdao.getVooById(idVoo);

		req.setAttribute("voo", vooSelecionado);
	
		RequestDispatcher rd = req.getRequestDispatcher("/AlterarVoo.jsp");

        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Voo vooAlterado = new Voo();
		
		vooAlterado.setOrigem(req.getParameter("origem"));
		vooAlterado.setDestino(req.getParameter("destino"));
		vooAlterado.setDataIda(req.getParameter("dataIda"));
		vooAlterado.setDataVolta(req.getParameter("dataVolta"));
		vooAlterado.setId(Integer.parseInt(req.getParameter("id")));
		
		VooDAO vd = new VooDAO();
		vd.update(vooAlterado);	
		resp.sendRedirect("ListarVoo");
	}
}
