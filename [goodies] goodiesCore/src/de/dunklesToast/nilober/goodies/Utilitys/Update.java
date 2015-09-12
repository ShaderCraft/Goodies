package de.dunklesToast.nilober.goodies.Utilitys;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public interface Update {
	
	
	public static byte[] checkforupdate(String url, byte[] post) throws Exception{
		URL u = new URL(url);
        HttpURLConnection con = (HttpURLConnection) u.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStream out = con.getOutputStream();
        out.write(post);
        out.close();
        if(con.getResponseCode() != 200) {
            throw new Exception("Server returned bad response code: " + con.getResponseCode() + " " + con.getResponseMessage());
        }
        InputStream in = con.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[8192];
        int cur = 0;
        while((cur = in.read(buff)) > 0) {
            baos.write(buff, 0, cur);
        }
        in.close();
        return baos.toByteArray();
		
	}

	
	
	/*
	 * 
	 * 	String post = "somethingToPost";
		System.out.println("Response: " + new String(getPost("http://your.url/", post.getBytes())));
	 * 
	 * 
	 * 
	 */
}
