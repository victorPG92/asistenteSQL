package com.asistente.sql.creator;

import java.util.ArrayList;
import java.util.List;

public class SentenciaSelect
{

	List<String> campos= new ArrayList<>();
	List<String> from= new ArrayList<>();
	List<String> where= new ArrayList<>();
	public List<String> getCampos()
	{
		return campos;
	}
	public void setCampos(List<String> campos)
	{
		this.campos = campos;
	}
	public List<String> getFrom()
	{
		return from;
	}
	public void setFrom(List<String> from)
	{
		this.from = from;
	}
	public List<String> getWhere()
	{
		return where;
	}
	public void setWhere(List<String> where)
	{
		this.where = where;
	}
	
	private String toString(List<String> l)
	{
		StringBuffer sb= new StringBuffer();
		for (String string : l)
		{
			sb.append(string+",");
		}
		sb.deleteCharAt(sb.length()-1);
		
		
		return sb.toString();
	}
	
	
	@Override
	public String toString()
	{
		
		return "SELECT " +toString(campos)+
				"\nFROM "+toString(from)+
				"\nWHERE "+toString(where);
	}
	
	
	
}
