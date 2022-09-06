package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import classes.Pacote;
import classes.Hospedagem;
import classes.Voo;
import connection.Conexao;

public class PacoteDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Método salvar
	public void save(Pacote pacote) {
		String sql = "INSERT INTO pacote (Valor, Desconto, Id_hospedagem, Id_voo) values(?, ?, ?, ?);";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setDouble(1, pacote.getValor());
			pstm.setInt(2, pacote.getDesconto());
			pstm.setInt(3, pacote.getHospedagem().getId());
			pstm.setInt(4, pacote.getVoo().getId());

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
	public List<Pacote> getPacote() {
		String sql = "select * from pacotes;";

		List<Pacote> pacote = new ArrayList<Pacote>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Pacote pac = new Pacote();
				Hospedagem h = new Hospedagem();
				Voo v = new Voo();

				pac.setId(rset.getInt("Id_pacote"));
				pac.setValor(rset.getDouble("Valor"));
				pac.setDesconto(rset.getInt("Desconto"));

				h.setId(rset.getInt("Id_hospedagem"));
				h.setIncluso(rset.getString("Incluso"));
				h.setDiarias(rset.getInt("Diarias"));
				pac.setHospedagem(h);

				v.setId(rset.getInt("Id_voo"));
				v.setDestino(rset.getString("Destino"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				v.setDataIda(dateFormat.format(rset.getDate("data_Ida")));
				pac.setVoo(v);

				pacote.add(pac);
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

		return pacote;
	}

	// Metodo atualizar
	public void update(Pacote pacote) {
		String sql = "UPDATE pacote SET Valor = ?, Desconto = ?, Id_hospedagem = ?, Id_voo = ? where Id_pacote = ?;";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setDouble(1, pacote.getValor());
			pstm.setInt(2, pacote.getDesconto());
			pstm.setInt(3, pacote.getHospedagem().getId());
			pstm.setInt(4, pacote.getVoo().getId());
			pstm.setInt(5, pacote.getId());

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
		String sql = "DELETE FROM pacote WHERE Id_pacote = ?";

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
	public Pacote getPacoteById(int id) {
		String sql = "select * from pacotes WHERE Id_pacote = ?;";

		Pacote pacote = new Pacote();
		Hospedagem hospedagem = new Hospedagem();
		Voo voo = new Voo();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			pacote.setId(rset.getInt("Id_pacote"));
			pacote.setValor(rset.getDouble("Valor"));
			pacote.setDesconto(rset.getInt("Desconto"));
		
			hospedagem.setId(rset.getInt("Id_hospedagem"));
			hospedagem.setIncluso(rset.getString("Incluso"));
			hospedagem.setDiarias(rset.getInt("Diarias"));
			pacote.setHospedagem(hospedagem);

			voo.setId(rset.getInt("Id_voo"));
			voo.setDestino(rset.getString("Destino"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			voo.setDataIda(dateFormat.format(rset.getDate("data_Ida")));			
			pacote.setVoo(voo);

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

		return pacote;
	}
}
