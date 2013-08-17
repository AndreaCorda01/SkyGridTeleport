package me.creeper96.skygrid;

import java.io.Serializable;
import java.util.Vector;

public class JoinList implements Serializable{


	
	
	Vector<String> lista = new Vector(30,5);

	public JoinList()
	{
		lista.add("start");
	}
	

	public boolean aggiungi(String nome)
	{
		if(!lista.contains(nome))
		{
			lista.add(nome);
			return true;
		}
		return false;
	}
	
	public boolean rimuovi(String nome)
	{
		if(lista.contains(nome))
		{
			lista.remove(nome);
			return true;
		}
		return false;
	}
	
	
	public boolean leggi(String nome)
	{
		return lista.contains(nome);
	}
	
	public Vector<String> dati()
	{
		return lista;
	}
}
