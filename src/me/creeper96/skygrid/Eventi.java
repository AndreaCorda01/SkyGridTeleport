package me.creeper96.skygrid;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Eventi implements Listener{

	
	
	
	
	@EventHandler
	public void Mondo(PlayerChangedWorldEvent event)
	{
		for(String s:Main.jl.dati())
		{
			System.out.println(s);
		}
		
		
		String name = event.getPlayer().getName();
		if(!Main.jl.leggi(name))
		{
		if(event.getPlayer().getWorld() == Main.server.getWorld(Main.conf.mondo))
		{
			Location lc = Main.sp.coordinate();
			lc.setWorld( Main.server.getWorld(Main.conf.mondo));
			
			Main.server.dispatchCommand(Main.server.getConsoleSender(), "tppos " +name + " " + lc.getBlockX() + " " + lc.getBlockY() + " " + lc.getBlockZ());
			event.getPlayer().sendMessage(ChatColor.RED +"Sei stato teletrasportato a caso nel mondo " + event.getPlayer().getWorld().getName());
			//event.getPlayer().teleport(lc);
			Main.jl.aggiungi(name);
			Main m = (Main) Main.plugin;
			m.serializza();
		}
		}
	}
	
	@EventHandler
	public void Entra(PlayerJoinEvent event)
	{
	String name = event.getPlayer().getName();
	if(!Main.jl.leggi(name))
	{
		if(event.getPlayer().getWorld() == Main.server.getWorld(Main.conf.mondo))
		{
		
		Location lc = Main.sp.coordinate();
		
		lc.setWorld( Main.server.getWorld(Main.conf.mondo));

		
		Main.server.dispatchCommand(Main.server.getConsoleSender(), "tppos " + name + " " + lc.getBlockX() + " " + lc.getBlockY() + " " + lc.getBlockZ());
		event.getPlayer().sendMessage(ChatColor.RED +"Sei stato teletrasportato a caso nel mondo " + event.getPlayer().getWorld().getName());
		Main.jl.aggiungi(name);
		Main m = (Main) Main.plugin;
		m.serializza();
		}
	}
	}
	
	
}
	
	
	
	

