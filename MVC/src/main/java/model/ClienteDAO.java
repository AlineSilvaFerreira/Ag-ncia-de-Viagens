package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Método salvar
	public void save(Cliente cliente) {

		String sql = "INSERT INTO cliente(Nome, Telefone, CPF, Email, Estado, Cidade, Bairro, Rua, Numero, CEP)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getCpf());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getEstado());
			pstm.setString(6, cliente.getCidade());
			pstm.setString(7, cliente.getBairro());
			pstm.setString(8, cliente.getRua());
			pstm.setInt(9, cliente.getNumero());
			pstm.setString(10, cliente.getCep());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Método mostrar
	public List<Cliente> getCliente() {
		String sql = "select * from cliente;";

		List<Cliente> cliente = new ArrayList<Cliente>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente cli = new Cliente();

				cli.setId(rset.getInt("Id_cliente"));
				cli.setNome(rset.getString("Nome"));
				cli.setTelefone(rset.getString("Telefone"));
				cli.setCpf(rset.getString("CEP"));
				cli.setEmail(rset.getString("Email"));
				cli.setEstado(rset.getString("Estado"));
				cli.setCidade(rset.getString("Cidade"));
				cli.setBairro(rset.getString("Bairro"));
				cli.setRua(rset.getString("Rua"));
				cli.setNumero(rset.getInt("Numero"));
				cli.setCep(rset.getString("CEP"));

				cliente.add(cli);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return cliente;
	}

	// Metodo atualizar
	public void update(Cliente cliente) {
		String sql = "UPDATE cliente set Nome = ?, Telefone = ?, CPF = ?, Email = ?, Estado = ?, Cidade = ?, Bairro = ?, Rua = ?, Numero = ?, CEP = ?  where Id_cliente = ?;";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getCpf());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getEstado());
			pstm.setString(6, cliente.getCidade());
			pstm.setString(7, cliente.getBairro());
			pstm.setString(8, cliente.getRua());
			pstm.setInt(9, cliente.getNumero());
			pstm.setString(10, cliente.getCep());
			pstm.setInt(11, cliente.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Método deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM cliente WHERE Id_cliente = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Método buscar por Id
	public Cliente getClienteById(int id) {
		String sql = "SELECT * FROM cliente WHERE Id_cliente = ?;";

		Cliente cli = new Cliente();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			cli.setId(rset.getInt("Id_cliente"));
			cli.setNome(rset.getString("Nome"));
			cli.setTelefone(rset.getString("Telefone"));
			cli.setCpf(rset.getString("CEP"));
			cli.setEmail(rset.getString("Email"));
			cli.setEstado(rset.getString("Estado"));
			cli.setCidade(rset.getString("Cidade"));
			cli.setBairro(rset.getString("Bairro"));
			cli.setRua(rset.getString("Rua"));
			cli.setNumero(rset.getInt("Numero"));
			cli.setCep(rset.getString("CEP"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return cli;
	}
}
