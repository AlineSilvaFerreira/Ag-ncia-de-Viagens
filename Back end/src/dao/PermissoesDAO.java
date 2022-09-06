package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Permissoes;
import connection.Conexao;

public class PermissoesDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo salvar
	public void save(Permissoes permissoes) {
		String sql = "INSERT INTO permissoes (Tipo_permissoes) values(?);";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, permissoes.getTipo());

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
	public List<Permissoes> getPermissoes() {
		String sql = "select * from permissoes;";

		List<Permissoes> permissoes = new ArrayList<Permissoes>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Permissoes permissao = new Permissoes();

				permissao.setId(rset.getInt("Id_permissoes"));
				permissao.setTipo(rset.getString("Tipo_permissoes"));

				permissoes.add(permissao);
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

		return permissoes;
	}

	// Metodo atualizar
	public void update(Permissoes permissoes) {
		String sql = "UPDATE permissoes set Tipo_permissoes = ? where Id_permissoes = ?;";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, permissoes.getTipo());

			pstm.setInt(2, permissoes.getId());

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
		String sql = "DELETE FROM permissoes WHERE Id_permissoes = ?";

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
	public Permissoes getPermissoesById(int id) {
		String sql = "SELECT * FROM permissoes WHERE Id_permissoes = ?;";

		Permissoes permissao = new Permissoes();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			permissao.setId(rset.getInt("Id_permissoes"));
			permissao.setTipo(rset.getString("Tipo_permissoes"));

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

		return permissao;
	}
}
