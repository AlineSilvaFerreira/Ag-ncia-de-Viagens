package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDAO;


@WebServlet("/excluir")
public class ExcluirClienteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idCliente = Integer.parseInt(req.getParameter("id"));
		Cliente clienteExcluido = new Cliente();
		clienteExcluido.setId(idCliente);

		ClienteDAO cdao = new ClienteDAO();

		cdao.deleteById(idCliente);

		resp.sendRedirect("ListarCliente");
	}

}


