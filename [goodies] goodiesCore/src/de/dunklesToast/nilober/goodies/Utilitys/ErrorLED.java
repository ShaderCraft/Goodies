package de.dunklesToast.nilober.goodies.Utilitys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.bukkit.Bukkit;

import de.dunklesToast.nilober.goodies.Main;

public class ErrorLED {

	
	
public static void openStream(){
	
	try{
	new BufferedReader(new InputStreamReader(new URL("http://192.168.2.120/goodies/error.php").openStream()));
	Main.ccs.sendMessage(Main.s + "There was an error in §4goodies§e!");
	}catch(MalformedURLException e){
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	
}