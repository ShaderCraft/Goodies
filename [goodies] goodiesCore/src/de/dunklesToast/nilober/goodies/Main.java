package de.dunklesToast.nilober.goodies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import de.dunklesToast.nilober.goodies.Extra.TNTReg;
import de.dunklesToast.nilober.goodies.commands.cmdBitLy;
import de.dunklesToast.nilober.goodies.commands.cmdDelete;
import de.dunklesToast.nilober.goodies.commands.cmdFavicon;
import de.dunklesToast.nilober.goodies.commands.cmdGet;
import de.dunklesToast.nilober.goodies.commands.cmdGoodies;
import de.dunklesToast.nilober.goodies.commands.cmdHat;
import de.dunklesToast.nilober.goodies.commands.cmdHead;
import de.dunklesToast.nilober.goodies.commands.cmdHelix;
import de.dunklesToast.nilober.goodies.commands.cmdHologram;
import de.dunklesToast.nilober.goodies.commands.cmdInfobook;
import de.dunklesToast.nilober.goodies.commands.cmdKick;
import de.dunklesToast.nilober.goodies.commands.cmdKill;
import de.dunklesToast.nilober.goodies.commands.cmdMute;
import de.dunklesToast.nilober.goodies.commands.cmdOp;
import de.dunklesToast.nilober.goodies.commands.cmdServer;
import de.dunklesToast.nilober.goodies.commands.cmdSet;
import de.dunklesToast.nilober.goodies.commands.cmdTpa;
import de.dunklesToast.nilober.goodies.commands.cmdTpaccept;
import de.dunklesToast.nilober.goodies.commands.cmdTpdeny;
import de.dunklesToast.nilober.goodies.commands.cmdWayPoint;
import de.dunklesToast.nilober.goodies.listener.ChatListener;
import de.dunklesToast.nilober.goodies.listener.CustomDMListener;
import de.dunklesToast.nilober.goodies.listener.JoinListener;
import de.dunklesToast.nilober.goodies.listener.NoArmorOnHoloListener;
import de.dunklesToast.nilober.goodies.listener.WayPointListener;
import de.dunklesToast.nilober.goodies.listener.stopEnderSpamListener;
import de.dunklesToast.nilober.goodies.messages.Messages;


public class Main extends JavaPlugin implements Listener{

    public final Logger logger = Logger.getLogger("Minecraft");

    public static List<Player> muted = new ArrayList<Player>();

    public static HashMap<Player, Player> tpa = new HashMap<Player, Player>();
    
    public static HashMap<String, ItemStack> invback = new HashMap<String, ItemStack>();

    public static String sqlerror = "§c[goodies]§4MySQL has encountered an error. Check Console!";
	public static Connection c = null;

    public static Main getInstance(){
		return instance;
    }
    

    public static ConsoleCommandSender ccs = Bukkit.getConsoleSender();
    
    public static String epre = "§c[§agoodies§7_§4PANIC§7_§4HANDLER§c] ";
    public static String s = "§d>>> §e";
    
	public static String currentversion;
	public static Main instance; 
	
	public static String noperm = ChatColor.translateAlternateColorCodes('&', Messages.getMessage("general.noperm"));
	public static String nocon = ChatColor.translateAlternateColorCodes('&', Messages.getMessage("general.onlyplayers"));
	
	@SuppressWarnings("static-access")
	@Override
	public void onEnable() {
		
		
		saveDefaultConfig();
        
        
		Bukkit.getConsoleSender().sendMessage("§a   ____    ___     ___    ____    ___   _____   ____   ");
		Bukkit.getConsoleSender().sendMessage("§a  / ___|  / _ \\   / _ \\  |  _ \\  |_ _| | ____| / ___|  ");
		Bukkit.getConsoleSender().sendMessage("§a | |  _  | | | | | | | | | | | |  | |  |  _|   \\___ \\");
		Bukkit.getConsoleSender().sendMessage("§a | |_| | | |_| | | |_| | | |_| |  | |  | |___   ___) |");
		Bukkit.getConsoleSender().sendMessage("§a  \\____|  \\___/   \\___/  |____/  |___| |_____| |____/ ");
		Bukkit.getConsoleSender().sendMessage("");
        
        logger.info("Enabled Goodies" + this.getDescription().getVersion() + "!");
		this.getServer().getPluginManager().registerEvents(this, this);

		
		
	    Messages.createFile();
	    Messages.addDefaults();
        initCommands();

        registerEvents();
        instance = this;
        this.getServer().getPluginManager().registerEvents(new TNTReg(), this);
        this.currentversion = this.getDescription().getVersion();
        System.out.println(this.getDescription().getVersion());
        
        
        
    }
	

	
	@Override
	public void onDisable() {

		if(this.getConfig().getBoolean("kick-on-rl") == true){
			
				for(Player pp : Bukkit.getOnlinePlayers()){
					if(!pp.isOp()){
					pp.kickPlayer(ChatColor.translateAlternateColorCodes('&', Messages.getMessage("kick.onrl")));
					}
				}
		}
		
	} 
	

	public void registerEvents() {
		new JoinListener(this);
		new ChatListener(this);
		new NoArmorOnHoloListener(this);
		new WayPointListener(this);
		new CustomDMListener(this);
		
		ccs.sendMessage(this.getConfig().getBoolean("stop-espam") + "");
		
		if(this.getConfig().getBoolean("stop-espam") == true){
		new stopEnderSpamListener(this);
			ccs.sendMessage("§d>>> §eEnabled StopEnderPearlSpam");
		}
	}

	
	private void initCommands() {
        getCommand("kill").setExecutor(new cmdKill(this));
        getCommand("hat").setExecutor(new cmdHat(this));
        getCommand("op").setExecutor(new cmdOp(this));
        getCommand("kick").setExecutor(new cmdKick(this));
        getCommand("get").setExecutor(new cmdGet(this));
        getCommand("goodies").setExecutor(new cmdGoodies(this));
        getCommand("mute").setExecutor(new cmdMute(this));
        getCommand("tpa").setExecutor(new cmdTpa(this));
        getCommand("tpaccept").setExecutor(new cmdTpaccept(this));
        getCommand("tpdeny").setExecutor(new cmdTpdeny(this));
        getCommand("head").setExecutor(new cmdHead(this));
        getCommand("hologram").setExecutor(new cmdHologram(this));
        getCommand("waypoint").setExecutor(new cmdWayPoint(this));
        getCommand("helix").setExecutor(new cmdHelix(this));
        getCommand("favicon").setExecutor(new cmdFavicon(this));
        getCommand("infobook").setExecutor(new cmdInfobook(this));
        getCommand("bitly").setExecutor(new cmdBitLy(this));
        getCommand("delete").setExecutor(new cmdDelete(this));
        getCommand("server").setExecutor(new cmdServer(this));
        getCommand("set").setExecutor(new cmdSet(this));
        
	}
	
}
