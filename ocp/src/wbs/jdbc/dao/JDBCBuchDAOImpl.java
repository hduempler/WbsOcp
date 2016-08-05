package wbs.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class JDBCBuchDAOImpl implements IBuchDAO {

	final String insertSQL = "INSERT INTO Buch VALUES (?,?,?,?)";
	final String updateSQL = "UPDATE Buch set ISBN = ?, TITEL= ?, AUTOR= ?, PREIS= ? WHERE ISBN = ?";
	final String selectSQL = "SELECT * FROM Buch";

	public JDBCBuchDAOImpl() {
	}

	@Override
	public void save(Buch buch) throws PersistenceException {
		try (Connection conn = DAOHelper.getConnection();
				PreparedStatement pstmtIns = conn.prepareStatement(insertSQL);
				PreparedStatement pstmtUpd = conn.prepareStatement(updateSQL);) {

			pstmtIns.setString(1, buch.getIsbn());
			pstmtIns.setString(2, buch.getTitel());
			pstmtIns.setString(3, buch.getAutor());
			pstmtIns.setDouble(4, buch.getPreis());
			try {
				pstmtIns.execute();

			} catch (MySQLIntegrityConstraintViolationException e) {
				pstmtUpd.setString(1, buch.getIsbn());
				pstmtUpd.setString(2, buch.getTitel());
				pstmtUpd.setString(3, buch.getAutor());
				pstmtUpd.setDouble(4, buch.getPreis());
				pstmtUpd.setString(5, buch.getIsbn());
				pstmtUpd.execute();
			}

		} catch (SQLException e) {
			throw new PersistenceException(e);
		}

	}

	@Override
	public List<Buch> findAll() throws PersistenceException {
		List<Buch> list = new ArrayList<>();
		try (Connection conn = DAOHelper.getConnection();
				Statement stmt = conn.createStatement()) {
			ResultSet res = stmt.executeQuery(selectSQL);
			while (res.next()) {
				Buch buch = new Buch();
				buch.setIsbn(res.getString(1));
				buch.setTitel(res.getString(2));
				buch.setAutor(res.getString(3));
				buch.setPreis(res.getDouble(4));
				list.add(buch);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e);
		}

		// TODO Auto-generated method stub
		return list;
	}

}
