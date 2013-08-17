package me.creeper96.skygrid;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

public static Conf conf;
public static Server server;
public static Plugin plugin;
	
public static JoinList jl;
public static Spawn sp;

public static String name = "SkyGridTeleport";
	
	public void onEnable()
	{	
		server = this.getServer();
		plugin = (Plugin) this;
		conf = new Conf();
		sp = new Spawn();

		jl = this.deSerializza();
		
		
		
		if(jl == null)
		{
			serializza();
		}
		
		server.getPluginManager().registerEvents(new Eventi(), this);
	}
	
	public void onDisable()
	{
		
	}
	
	
	
	
	
	public void serializza()
	{
		try{
			JoinList file = new JoinList();
			File f = new File("plugins/" + name + "/giocatori.dat");
			if(!f.exists())
			{
				f.createNewFile();
				System.out.println("File creato");
			}
		      FileOutputStream fout = new FileOutputStream("plugins/" + name + "/giocatori.dat");
		      ObjectOutputStream output = new ObjectOutputStream(fout);
		      output.writeObject(file);
		      output.flush();
		      output.close();
		     // System.out.println("Salvato con successo"); 
		 } catch (IOException e) { e.printStackTrace(); System.out.println("Impossibile salvare");}				
	}
	
	
	private JoinList deSerializza()
	{	
		FileInputStream fin;
		ObjectInputStream input = null;
		
		JoinList letto = null; //file che deve essere letto dal .dat
		
		File f = new File("plugins/" + name + "/giocatori.dat");
		if(f.exists())
		{
			//System.out.println("File dati giocatori esiste");
			try{
				fin = new FileInputStream(f.getPath());
				input = new ObjectInputStream(fin);
				//input.close();
				}catch (IOException e){e.printStackTrace();}
		}
		else
		{
			this.serializza();
			try{
				fin = new FileInputStream("plugins/" + name + "/giocatori.dat");
				input = new ObjectInputStream(fin);
		
				}catch (IOException e){System.out.println("errore lettura file2");}
		}
		//carica la classe con i dati del player
		
		try{
			letto = (JoinList) input.readObject();
			input.close();
			} catch (IOException e){e.printStackTrace();} catch (ClassNotFoundException e)  {
				e.printStackTrace();
			}
		return letto;
	}
	
	public static void main(String[] arg)
	{
		Main m =new Main();
		jl = m.deSerializza();
		//m.jl.aggiungi("ciao6");
		//System.out.println(m.jl.leggi("ciao8"));
		System.out.println(jl);
		for(String s:jl.dati())
		{
			System.out.println(s);
		}
		
		m.serializza();
		

	}
	
}
