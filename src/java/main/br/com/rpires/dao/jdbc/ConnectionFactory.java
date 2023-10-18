/**
 * 
 */
package br.com.rpires.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author rodrigo.pires
 *
 */
public class ConnectionFactory {

	
	private static Connection connection;
	
	private ConnectionFactory(Connection connection) {
		
	}
	
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = initConnection();
			return connection;
		} else if (connection.isClosed()) {
			connection = initConnection();
			return connection;
		} else {
			return connection;
		}
	}

	private static Connection initConnection() {
		try {
            return DriverManager.getConnection(
					"jdbc:postgresql://5432/exercise_mod_sql","postgres","16833200");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
}
