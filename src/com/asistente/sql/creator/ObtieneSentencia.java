package com.asistente.sql.creator;

import java.util.Arrays;

//import org.codehaus.jackson.map.ser.std.StdArraySerializers.CharArraySerializer;

public class ObtieneSentencia
{

	
	public SentenciaSelect obtenerSentencia(String sql)
	{
		sql=sql.toUpperCase();
		if(sql.startsWith("SELECT"))
		{
			String camposS= sql.substring("SELECT".length(), sql.indexOf("FROM"));//.trim();
			
			String resto=sql.substring("SELECT".length()+camposS.length());
			
			camposS=camposS.trim();
			
			//System.out.println(camposS);
			
			
			int posWhere=resto.indexOf("WHERE");
			if(posWhere==-1)posWhere=resto.length();
			String fromsS=resto.substring(0,posWhere);
			
			//System.out.println(fromsS);
			
			//System.out.println(resto +" " + resto.length()+" "+fromsS.length());
			resto=resto.substring(fromsS.length());
			
			fromsS=fromsS.replace("FROM", "").trim();
			String wheresS="";
			
			
			if(resto.contains("WHERE"))
			{
				wheresS= resto.replace("WHERE","");
			}
			/*
			System.out.println("SELECT "+ camposS);
			System.out.println("FROM "+fromsS);
			if(!wheresS.isEmpty())
			System.out.println("WHERE "+wheresS);
			System.out.println();
			*/
			SentenciaSelect sentencia=new SentenciaSelect();
			sentencia.setCampos(Arrays.asList(camposS.split(",")));
			sentencia.setFrom(Arrays.asList(fromsS.split(",")));
			sentencia.setWhere(Arrays.asList(wheresS.split(",")));
			
			System.out.println(sentencia);
			
		}
		return null;
	}
	
	
	public static void main(String[] args)
	{
		String sqlSinWhere="select * from table t";
		String sqlSinWhereJoin="select * from table t join s on t.c=s.c";
		
		String sqlConWhere="select * from table t where a=A";
		String sqlConWhereJoin="select * from table t join s on t.c=s.c where a=A";
		
		
		
		ObtieneSentencia o= new ObtieneSentencia();
		
		o.obtenerSentencia(sqlSinWhere);
		o.obtenerSentencia(sqlSinWhereJoin);
		o.obtenerSentencia(sqlConWhere);
		o.obtenerSentencia(sqlConWhereJoin);
		
		
		
		
	}
}
