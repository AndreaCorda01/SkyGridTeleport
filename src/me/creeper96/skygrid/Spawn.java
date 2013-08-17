package me.creeper96.skygrid;

import org.bukkit.Location;
import org.bukkit.World;

public class Spawn {

	
	private int dist = Main.conf.distanza;
	
	
	
	private double casuale()
	{
		double numero =  Math.random() * Main.conf.limite;
		
		int positivo = (int) Math.random() * 10;
		
		if(positivo < 5)
		{
			numero = numero * -1;
		}
		
		numero += Main.conf.aggiusta_xz;
		
		double sott = numero%Main.conf.distanza;
		numero -= sott;
		
		return numero;

	}
	

	private double casuale_altezza()
	{
		double numero =  Math.random() * Main.conf.altezza;

		if(numero < 10)
		{
			double agg = 10 - numero;
			numero += agg;
		}
		
		double sott = numero%Main.conf.distanza;
		numero -= sott;
		
		numero += Main.conf.aggiusta_y;
		
		return numero;

	}
	

	
	
	
	public Location coordinate()
	{
		Location pos;
		
		World mondo = Main.server.getWorld(Main.conf.mondo);
		mondo = null;
		
		double x =casuale();
		double y = casuale_altezza() + 1;
		double z = casuale();
		
		pos = new Location(mondo, x, y, z);
		
		return pos;
	}

	public static void main(String[] arg)
	{
		
		new Main();
		Spawn sp = new Spawn();
		System.out.println(sp.coordinate());
	
	}
}