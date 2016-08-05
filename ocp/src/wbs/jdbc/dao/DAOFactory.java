package wbs.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
 
	public static IBuchDAO getBuchDAO(){
		IBuchDAO buchDAO;
		buchDAO = new JDBCBuchDAOImpl();
		return buchDAO;
	};
}
