package Master.connection;

import java.sql.*;

public class connectionfactory {
	Connection con = null;
	
	public Connection getcon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}