package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Itens_reserva;
import classes.Pacote;
import classes.Reserva;
import connection.Conexao;

public class Itens_reservaDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Método salvar
	public void save(Itens_reserva itens_reserva) {
		String sql = "INSERT INTO itens_reserva (Quantidade, Valor, Id_pacote) values(?, ?, ?);";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, itens_reserva.getQuantidade());
			pstm.setDouble(2, itens_reserva.getValor());
			pstm.setInt(3, itens_reserva.getPacote().getId());
			//pstm.setInt(4, itens_reserva.getReserva().getId());

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
	public List<Itens_reserva> getItens_reserva() {
		String sql = "select * from itens_reserva;";

		List<Itens_reserva> itens_reserva = new ArrayList<Itens_reserva>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Itens_reserva itens = new Itens_reserva();
				Pacote pacote = new Pacote();
				Reserva reserva = new Reserva();

				itens.setId(rset.getInt("Id_itens"));
				itens.setQuantidade(rset.getInt("Quantidade"));
				itens.setValor(rset.getDouble("Valor"));

				pacote.setId(rset.getInt("Id_pacote"));
				itens.setPacote(pacote);

				reserva.setId(rset.getInt("Id_reserva"));
				itens.setReserva(reserva);

				itens_reserva.add(itens);
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

		return itens_reserva;
	}

	// Metodo atualizar
	public void update(Itens_reserva itens_reserva) {
		String sql = "UPDATE itens_reserva SET Quantidade = ?, Valor = ?, Id_pacote = ?, Id_reserva =? WHERE Id_itens = ?;";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, itens_reserva.getQuantidade());
			pstm.setDouble(2, itens_reserva.getValor());
			pstm.setInt(3, itens_reserva.getPacote().getId());
			pstm.setInt(4, itens_reserva.getReserva().getId());
			pstm.setInt(5, itens_reserva.getId());

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
		String sql = "DELETE FROM itens_reserva WHERE Id_itens = ?";

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
		public Itens_reserva getItensById(int id) {
			String sql = "select * from itens_reserva WHERE Id_itens = ?;";

			Itens_reserva itens = new Itens_reserva();
			Pacote pacote = new Pacote();
			Reserva reserva = new Reserva();

			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				rset = pstm.executeQuery();
				rset.next();

				itens.setId(rset.getInt("Id_itens"));
				itens.setQuantidade(rset.getInt("Quantidade"));
				itens.setValor(rset.getDouble("Valor"));

				pacote.setId(rset.getInt("Id_pacote"));
				itens.setPacote(pacote);

				reserva.setId(rset.getInt("Id_reserva"));
				itens.setReserva(reserva);

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

			return itens;
		}
}
