package wbs.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTestDemo {

	public static void main(String[] args) throws SQLException{
		String url="jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password="";
		try(Connection conn = DriverManager.getConnection(url,user,password)) {
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println(meta.supportsTransactions());
			
		}
		
	}

}
