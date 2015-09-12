package de.dunklesToast.nilober.goodies.messages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class Messages
{
  public static File file = new File("plugins/goodies", "messages.yml");
  public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
  
  public static void createFile()
  {
    if (!file.exists()) {
      try
      {
        file.createNewFile();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    saveFile();
  }
  
  public static String[] getLineMessage(String path)
  {
    List<String> list = cfg.getStringList("message.joinown");
    String[] stringArray = (String[])list.toArray(new String[list.size()]);
    return stringArray;
  }
  
  public static String getMessage(String path)
  {
    return cfg.getString(path);
  }
  
  public static void addDefaults()
  {
    if (cfg.getString("goodies.prefix") == null)
    {
      cfg.set("goodies.prefix", "&4[&agoodies&4] &2");
    }
    
    
      //Allgemein
    if (cfg.getString("general.toomuchargs") == null)
    {     
      cfg.set("general.toomuchargs", "&4Too much Arguments!");
      cfg.set("general.noperm", "&cWe´re sorry but it seems that you are not allowed to execute this command.");
      cfg.set("general.onlyplayers", "&4This Command is only for Players. We´re sorry");
      cfg.set("general.onlyconsole", "&4This command is only for the console!");
      
  }
      
      //Beschreibunge von /goodies <command>
    if (cfg.getString("help.main") == null)
    {
      cfg.set("help.main", "Type /goodies <command> to get help for a command! Example: /goodies hat");
      cfg.set("help.hat", "&aWith /hat you can have a nice Hat! Just hold a Block in your Hand and type /hat and Whooosh! its on your hat :D");
      cfg.set("help.op", "&4This Command is OP §lONLY! §cYou can set Players OP by typing /op <player>. For deop just type /deop <player>");
      cfg.set("help.kick", "With /kick <player> <reason >you can easy kick Players from a Server. By typing /kickall <reason> you can kick every player!");
      cfg.set("help.kill", "You want to kill a Player? Do it with /kill <player>! Leave the name and you kill yourself");
      cfg.set("help.configbook", "&2Take a look in your Inventory! There is a Book with all the information about the Config!");
    } 
      //Alles was mit "Hats" zu tun hat!
    if (cfg.getString("hat.newhat") == null)
    {  
      cfg.set("hat.newhat", "&aEnjoy your new Hat!");
      cfg.set("hat.musthaveinhand", "&4You must have something in your Hand!");
      cfg.set("hat.removed", "&aYou have removed your Hat!");
      cfg.set("hat.toomuch", "&cTry /hat");
    }
      
      //Alles was mit "kick" zu tun hat
    if (cfg.getString("kick.succes") == null)
    {
      cfg.set("kick.succes", "&aYou succesfully kicked %Player for %Reason");
    } 
      
      //JoinListener
    if (cfg.getString("join.message") == null)
    {
      cfg.set("join.message", "&d%Player &5has joined &d%Servername");
    }
      
      //KickOnRL
    if (cfg.getString("kick.onrl") == null)
    {
      cfg.set("kick.onrl", "&aWe are &cshortly &areloading our Server!");
    }
      //head
    if (cfg.getString("head.local") == null)
    {
      cfg.set("head.local", "&2This is your head!");
      cfg.set("head.external", "&2This is the head from %headowner%");
    }
  
    if (cfg.getString("holo.succes") == null)
    {
      cfg.set("holo.succes", "&2You succesfully spawned a Hologram! Remove it with /holo rm <text from the Holo> (with colorcodes!)");
      cfg.set("holo.rmfail", "&2Error while removing the Hologram. Hint: You have to write the ColorCodes, too!");
      
    }      
    
    
    
    
      try
      {
        cfg.save(file);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  
  
  public static void saveFile()
  {
    try
    {
      cfg.save(file);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
}
