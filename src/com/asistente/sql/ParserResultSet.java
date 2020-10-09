package com.asistente.sql;


import java.sql.ResultSet;

/**
 * Transforma un resultset obtenido de una consulta en un objeto tipo <T>
 * @author victor
 *
 * @param <T>
 */
public interface ParserResultSet <T>
{
	
	public T parse(ResultSet rs);

}
