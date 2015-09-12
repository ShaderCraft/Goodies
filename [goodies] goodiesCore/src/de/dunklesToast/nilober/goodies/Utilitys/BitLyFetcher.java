package de.dunklesToast.nilober.goodies.Utilitys;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.bukkit.command.CommandSender;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.dunklesToast.nilober.goodies.Main;

public class BitLyFetcher {
   
   static URL url;
   
   public static String getShortLink(String lurl, CommandSender cs) {
	   
	  // String at = Main.getInstance().getConfig().getString("BitLy.Token");
	   String at = "f50aab16b48ee362178ab85d4631ed316cb8839b";
     
      try {
         url = new URL("https://api-ssl.bitly.com/v3/shorten?access_token=" + at + "&longUrl=" + lurl);
         
         if(!url.toString().contains("http://")){
        	 cs.sendMessage(Main.s + "Added §ahttp:// §eto your URL!");
        	url = new URL("https://api-ssl.bitly.com/v3/shorten?access_token=" + at + "&longUrl=http://" + lurl);
         }
         
         InputStream stream = url.openStream();
         InputStreamReader inr = new InputStreamReader(stream);
         BufferedReader reader = new BufferedReader(inr);
         String s = null;
         StringBuilder sb = new StringBuilder();
         while ((s = reader.readLine()) != null) {
            sb.append(s);
         }
         String result = sb.toString();
         
         JsonElement element = new JsonParser().parse(result);
         JsonObject obj = element.getAsJsonObject();
         
         cs.sendMessage(element.toString());
         
         String shorte = obj.get("hash").toString();
         
         shorte = shorte.substring(6);
         shorte = shorte.substring(0, shorte.length() - 1);
         
         String url1 = "https://api-ssl.bitly.com/v3/shorten?access_token=" + at + "&longUrl=" + lurl;
         
         return shorte;
         
      } catch (IOException e) {
         e.printStackTrace();
      }
      return null;
   }
   }

