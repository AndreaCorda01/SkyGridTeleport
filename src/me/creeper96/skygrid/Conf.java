package me.creeper96.skygrid;

public class Conf {

	
	public int limite = 400;
	public int distanza = 5;
	public String mondo = "SkyGrid";
	public int altezza = 150;
	public int aggiusta_xz = 0;
	public int aggiusta_y = 0;
	
	
	public Conf()
	{
		Main.plugin.saveDefaultConfig();
		limite = Main.plugin.getConfig().getInt("limite");
		distanza = Main.plugin.getConfig().getInt("distanza");
		mondo = Main.plugin.getConfig().getString("mondo");
		altezza = Main.plugin.getConfig().getInt("altezza");
		aggiusta_xz = Main.plugin.getConfig().getInt("aggiusta_xz");
		aggiusta_y = Main.plugin.getConfig().getInt("aggiusta_y");
	}
}
