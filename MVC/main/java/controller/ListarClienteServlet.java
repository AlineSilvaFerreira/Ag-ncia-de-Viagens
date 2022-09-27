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

import model.Cliente;
import model.ClienteDAO;

@WebServlet("/ListarCliente")
public class ListarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cliente> cliente = new ArrayList<Cliente>();
		ClienteDAO clientedao = new ClienteDAO();
		cliente = clientedao.getCliente();
		request.setAttribute("listaClientes", cliente);

		RequestDispatcher dispatcher = request.getRequestDispatcher("MostrarCliente.jsp");
		dispatcher.forward(request, response);
		
	}

}
