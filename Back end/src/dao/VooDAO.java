package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import classes.Voo;
import connection.Conexao;

public class VooDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Método salvar
	public void save(Voo voo) {

		String sql = "INSERT INTO voo (Origem, Destino, Data_Ida, Data_Volta, Valor)" + " VALUES( ?, ?, ?, ?, ?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, voo.getOrigem());
			pstm.setString(2, voo.getDestino());

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(3, new Date(formatter.parse(voo.getDataIda()).getTime()));

			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(4, new Date(formatter1.parse(voo.getDataVolta()).getTime()));

			pstm.setDouble(5, voo.getValor());

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
	public List<Voo> getVoo() {
		String sql = "select * from voo;";

		List<Voo> voos = new ArrayList<Voo>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Voo voo = new Voo();

				voo.setId(rset.getInt("Id_voo"));
				voo.setOrigem(rset.getString("Origem"));
				voo.setDestino(rset.getString("Destino"));

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				voo.setDataIda(dateFormat.format(rset.getDate("data_Ida")));

				SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
				voo.setDataVolta(dateFormat1.format(rset.getDate("data_Volta")));

				voo.setValor(rset.getDouble("Valor"));

				voos.add(voo);
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

		return voos;
	}

	// Método atualizar
	public void update(Voo voo) {
		String sql = "UPDATE voo SET Origem = ?, Destino = ?, Data_Ida = ?, Data_Volta = ?, Valor = ? WHERE Id_voo = ?;";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, voo.getOrigem());
			pstm.setString(2, voo.getDestino());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(3, new Date(formatter.parse(voo.getDataIda()).getTime()));

			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(4, new Date(formatter1.parse(voo.getDataVolta()).getTime()));

			pstm.setDouble(5, voo.getValor());
			pstm.setInt(6, voo.getId());

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
		String sql = "DELETE FROM voo WHERE Id_voo = ?";

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
		public Voo getVooById(int id) {
			String sql = "SELECT * FROM voo WHERE Id_voo = ?;";

			Voo voo = new Voo();

			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				rset = pstm.executeQuery();

				rset.next();

				voo.setId(rset.getInt("Id_voo"));
				voo.setOrigem(rset.getString("Origem"));
				voo.setDestino(rset.getString("Destino"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				voo.setDataIda(dateFormat.format(rset.getDate("data_Ida")));

				SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
				voo.setDataVolta(dateFormat1.format(rset.getDate("data_Volta")));

				voo.setValor(rset.getDouble("Valor"));

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

			return voo;
		}
}

