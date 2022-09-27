package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDAO;

@WebServlet("/alterar")
public class AlterarClienteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idContato = Integer.parseInt(req.getParameter("id"));
		ClienteDAO cdao = new ClienteDAO();
		Cliente clienteSelecionado = cdao.getClienteById(idContato);

		req.setAttribute("cliente", clienteSelecionado);
	
		RequestDispatcher rd = req.getRequestDispatcher("/AlterarCliente.jsp");

        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente clienteAlterado = new Cliente();		
		clienteAlterado.setNome(req.getParameter("nome"));
		clienteAlterado.setTelefone(req.getParameter("telefone"));
		clienteAlterado.setCpf(req.getParameter("cpf"));
		clienteAlterado.setEstado(req.getParameter("estado"));
		clienteAlterado.setCidade(req.getParameter("cidade"));
		clienteAlterado.setBairro(req.getParameter("bairro"));
		clienteAlterado.setRua(req.getParameter("rua"));
		clienteAlterado.setCep(req.getParameter("cep"));
		clienteAlterado.setNumero(Integer.parseInt(req.getParameter("numero")));
		clienteAlterado.setId(Integer.parseInt(req.getParameter("id")));
		
		ClienteDAO cd = new ClienteDAO();
		cd.update(clienteAlterado);	
		resp.sendRedirect("ListarCliente");
	}
}
