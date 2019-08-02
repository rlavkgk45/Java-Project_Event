package event.model.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	static Properties propertiesInfo = new Properties();
	static{ 
		try {
			propertiesInfo.load(new FileInputStream("db.properties") );
			Class.forName(propertiesInfo.getProperty("jdbc.driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(propertiesInfo.getProperty("jdbc.url") , 
											propertiesInfo.getProperty("jdbc.id"), 
											propertiesInfo.getProperty("jdbc.pw"));
	}

	// DML¿ë
	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// SELECT¿ë
	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			close(con, stmt);
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
}