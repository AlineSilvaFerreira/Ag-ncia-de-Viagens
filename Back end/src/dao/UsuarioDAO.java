package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Cliente;
import classes.Permissoes;
import classes.Usuario;
import connection.Conexao;

public class UsuarioDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Método salvar
	public void save(Usuario usuario) {
		String sql = "INSERT INTO usuário (Login, Senha, Id_cliente, Id_permissoes) values(?, ?, ?, ?);";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getSenha());
			pstm.setInt(3, usuario.getCliente().getId());
			pstm.setInt(4, usuario.getPermissoes().getId());

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

	// Método ler
	public List<Usuario> getUsuario() {
		String sql = "select * from usuarios;";

		List<Usuario> usuario = new ArrayList<Usuario>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario user = new Usuario();
				Cliente cli = new Cliente();
				Permissoes permissao = new Permissoes();

				user.setId(rset.getInt("Id_usuario"));
				user.setLogin(rset.getString("Login"));
				user.setSenha(rset.getString("Senha"));

				cli.setId(rset.getInt("Id_cliente"));
				cli.setNome(rset.getString("Nome"));
				user.setCliente(cli);

				permissao.setId(rset.getInt("Id_permissoes"));
				permissao.setTipo(rset.getString("Tipo_permissoes"));
				user.setPermissoes(permissao);

				usuario.add(user);
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

		return usuario;
	}

	// Metodo atualizar
	public void update(Usuario usuario1) {
		String sql = "UPDATE usuário SET Login = ?, Senha = ?, Id_cliente = ?, Id_permissoes = ? where Id_usuario = ?;";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario1.getLogin());
			pstm.setString(2, usuario1.getSenha());
			pstm.setInt(3, usuario1.getCliente().getId());
			pstm.setInt(4, usuario1.getPermissoes().getId());
			pstm.setInt(5, usuario1.getId());

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

	// Metodo deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM usuário WHERE Id_usuario = ?";

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

	//Método buscar por id
	public Usuario getUsuarioById(int id) {
		String sql = "select * from usuarios WHERE Id_usuario = ?;";

		Usuario usuario = new Usuario();
		Cliente cliente = new Cliente();
		Permissoes permissoes = new Permissoes();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			usuario.setId(rset.getInt("Id_usuario"));
			usuario.setLogin(rset.getString("Login"));
			usuario.setSenha(rset.getString("Senha"));
			
			cliente.setId(rset.getInt("Id_cliente"));
			cliente.setNome(rset.getString("Nome"));
			usuario.setCliente(cliente);

			permissoes.setId(rset.getInt("Id_permissoes"));
			permissoes.setTipo(rset.getString("Tipo_permissoes"));
			usuario.setPermissoes(permissoes);

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

		return usuario;
	}
}
