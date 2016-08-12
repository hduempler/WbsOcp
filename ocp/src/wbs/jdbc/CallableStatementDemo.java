package wbs.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "";
		CallableStatement callableStatement;
		ResultSet resultSet;
		String sql = "{call booksByPrice(?, ?)}";
		double fromPrice = 20;
		double toPrice = 100;
		try (Connection conn = DriverManager.getConnection(url, user,
				password)) {
			callableStatement = conn.prepareCall(sql);
			callableStatement.setDouble(1, fromPrice);
			callableStatement.setDouble(2, toPrice);
			resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("isbn")
						.replaceAll("(\\d)(\\d{3})(\\d{5})(\\d)", "$1-$2-$3-$4")
						+ "; " + resultSet.getString("autor") + "; "
						+ resultSet.getString("titel") + "; " + String.format(
								"%,.2f Euro", resultSet.getDouble("preis")));
			}
			callableStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
