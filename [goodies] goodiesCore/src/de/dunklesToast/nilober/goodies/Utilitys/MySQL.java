package de.dunklesToast.nilober.goodies.Utilitys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import de.dunklesToast.nilober.goodies.Main;

public class MySQL {
    
    public static String host = "localhost";
    public static String port = "3306";
    public static String database = "test";
    public static String username = "localhost";
    public static String password = "password";
    public static Connection con;
    
    public static void connect(){
        if (!isConnected()){
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                System.out.println(Main.s + "[MySQL] Connected");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static boolean isConnected(){
        return (con == null ? false : true);
    }
    public static void disconnect(){
        if (isConnected()){
            try {
                con.close();
                System.out.println(Main.s + "[MySQL] Disconnected!");
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Connection getConnnection(){
        return con;
    }
    
}
