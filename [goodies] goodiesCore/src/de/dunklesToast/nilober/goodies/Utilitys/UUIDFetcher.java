package de.dunklesToast.nilober.goodies.Utilitys;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UUIDFetcher {
   
   private static Map<String, String> uuidCache;
   
   static {
      uuidCache = new HashMap<String, String>();
   }
   public static String getUUID(String username) {
      if (uuidCache.containsKey(username)) return uuidCache.get(username);
      try {
         URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + username);
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
         if(element == null){
        	 return null;
         }
         JsonObject obj = element.getAsJsonObject();
         
         String uuid = obj.get("id").toString();
         
         uuid = uuid.substring(1);
         uuid = uuid.substring(0, uuid.length() - 1);
         
         uuidCache.put(username, uuid);
         
         return uuid;
         
      } catch (IOException e) {
         e.printStackTrace();
      }
      return null;
   }
   public static ArrayList<String> getLastName(String uuid){
	   
	   try {
	         URL url = new URL("https://api.mojang.com/user/profiles/" + uuid + "/names");
	         InputStream stream = url.openStream();
	         InputStreamReader inr = new InputStreamReader(stream);
	         BufferedReader reader = new BufferedReader(inr);
	         String s = null;
	         StringBuilder sb = new StringBuilder();
	         while ((s = reader.readLine()) != null) {
	            sb.append(s);
	         }
	         String result = sb.toString();

	         JsonArray array = new JsonParser().parse(result).getAsJsonArray();
	         ArrayList<String> lastname = new ArrayList<String>();
	         ArrayList<String> changeat = new ArrayList<String>();
	         for (int i = 0; i < array.size(); i++) {
	        	 JsonObject object = array.get(i).getAsJsonObject();
	        	 String name = object.get("name").getAsString();
	        	 String changedAt = (object.get("changedToAt") != null ? object.get("changedToAt").getAsString() : null);
	        	 lastname.add(name);
	        	 changeat.add(changedAt);
	         }
	         return lastname;
	         
	         
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   return null;
	   
   }
}

