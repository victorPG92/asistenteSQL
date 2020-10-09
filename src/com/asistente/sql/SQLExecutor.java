package com.asistente.sql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejecuta una sentencia sql 
 * @author victor
 *
 * @param <T>
 */
public class SQLExecutor <T>
{
	ParserResultSet<T> parser;
	DBProperties dbProperties= new DBProperties();
	DBConnection conDB = new DBConnection(); 

	
	public List<T> ejecutarConsultaSql(String sql) throws SQLException {
		Connection con = conDB.conectar();

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<T> resultList= new ArrayList<>();
		// if( rs.isBeforeFirst())
		while (rs.next()) {
			T elem = parser.parse(rs);
			//System.out.println(elem);
			resultList.add(elem);
		}
		
		ps.close();
		con.close();

		
		return resultList;

	}
	
	public boolean ejecutarActualizacionSql(String sql) throws SQLException {
	
		Connection con = conDB.conectar();
		
		Statement st = con.createStatement();
		st.execute(sql);
		
		st.close();
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate(sql);
		
		ps.close();
		
		con.close();

		return true;

	}
	
	


	public ParserResultSet<T> getParser() {
		return parser;
	}


	public void setParser(ParserResultSet<T> parser) {
		this.parser = parser;
	}


	public DBProperties getDbProperties() {
		return dbProperties;
	}


	public void setDbProperties(DBProperties dbProperties) {
		this.dbProperties = dbProperties;
	}


	public DBConnection getConDB() {
		return conDB;
	}


	public void setConDB(DBConnection conDB) {
		this.conDB = conDB;
	}
	
	

}
