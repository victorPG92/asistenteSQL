package com.asistente.sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Se conecta a la base de datoss
 * @author victor
 *
 */
public class DBConnection
{

	//ParserResultSet<T> resultParser;

	DBProperties dbProperties= new DBProperties();

	public Connection conectar() {
		Connection conn = null;

		try {
			Class.forName(dbProperties.getDriver());
			conn = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getUsername(), dbProperties.getPassword());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	

	

}
