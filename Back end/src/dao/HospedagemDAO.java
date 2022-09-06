package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Hospedagem;
import connection.Conexao;

public class HospedagemDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo salvar
	public void save(Hospedagem hospedagem) {
		String sql = "INSERT INTO hospedagem (Incluso, Diarias) values(?, ?);";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, hospedagem.getIncluso());
			pstm.setInt(2, hospedagem.getDiarias());

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
		public List<Hospedagem> getHospedagem() {
			String sql = "select * from hospedagem;";

			List<Hospedagem> hospedagem = new ArrayList<Hospedagem>();

			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				while (rset.next()) {
					Hospedagem h = new Hospedagem();

					h.setId(rset.getInt("Id_hospedagem"));
					h.setIncluso(rset.getString("Incluso"));
					h.setDiarias(rset.getInt("Diarias"));

					hospedagem.add(h);
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

			return hospedagem;
		}

		// Metodo atualizar
		public void update(Hospedagem hospedagem) {
			String sql = "UPDATE hospedagem SET Incluso = ?, Diarias = ? WHERE Id_hospedagem = ?;";

			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);

				pstm.setString(1, hospedagem.getIncluso());
				pstm.setInt(2, hospedagem.getDiarias());
				pstm.setInt(3, hospedagem.getId());

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
			String sql = "DELETE FROM hospedagem WHERE Id_hospedagem = ?";

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
		public Hospedagem getHospedagemById(int id) {
			String sql = "SELECT * FROM hospedagem WHERE Id_hospedagem = ?;";

			Hospedagem h = new Hospedagem();

			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				rset = pstm.executeQuery();

				rset.next();

				h.setId(rset.getInt("Id_hospedagem"));
				h.setIncluso(rset.getString("Incluso"));
				h.setDiarias(rset.getInt("Diarias"));

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

			return h;
		}
	
}
