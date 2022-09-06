package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Itens_reserva;
import classes.Reserva;
import classes.Usuario;
import connection.Conexao;

public class ReservaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Método salvar
	public void save(Reserva reserva) {
		String sql = "INSERT INTO reserva (Tipo_pag, Valor_total, Id_usuario) values( ?, ?, ?);";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, reserva.getTipoPagamento());
			pstm.setDouble(2, reserva.valorTotal());
			pstm.setInt(3, reserva.getUsuario().getId());

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
	public List<Reserva> getReserva() {
		String sql = "select * from reserva;";

		List<Reserva> reserva = new ArrayList<Reserva>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva reser = new Reserva();
				Usuario u = new Usuario();
				List<Itens_reserva> itens = new ArrayList<Itens_reserva>();

				reser.setId(rset.getInt("Id_reserva"));
				reser.setTipoPagamento(rset.getString("Tipo_pag"));
				reser.setValor(rset.getDouble("Valor_total"));

				u.setId(rset.getInt("Id_usuario"));
				
				reser.setUsuario(u);
				
				for(int i = 0; i <itens.size(); i++) {
					return (List<Reserva>) itens.get(i);
					}
				reserva.add(reser);
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

		return reserva;
	}

	// Metodo atualizar
	public void update(Reserva reserva) {
		String sql = "UPDATE reserva SET Tipo_pag = ?, Valor_total = ?, Id_usuario = ? where Id_reserva = ?;";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, reserva.getTipoPagamento());
			pstm.setDouble(2, reserva.getValor());
			pstm.setInt(3, reserva.getUsuario().getId());
			pstm.setInt(4, reserva.getId());

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
		String sql = "DELETE FROM reserva WHERE Id_reserva = ?";

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

	// Método buscar por id
	public Reserva getReservaById(int id) {
		String sql = "select * from reserva WHERE Id_reserva = ?;";

		Reserva reserva = new Reserva();
		Usuario usuario = new Usuario();
		List<Itens_reserva> itens = new ArrayList<>(); 

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			reserva.setId(rset.getInt("Id_reserva"));
			reserva.setTipoPagamento(rset.getString("Tipo_pag"));
			reserva.setValor(rset.getDouble("Valor_total"));

			usuario.setId(rset.getInt("Id_usuario"));
			reserva.setUsuario(usuario);
			
			
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

		return reserva;
	}
}
