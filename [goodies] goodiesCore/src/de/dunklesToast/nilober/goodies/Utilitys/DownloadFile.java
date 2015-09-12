package de.dunklesToast.nilober.goodies.Utilitys;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public interface DownloadFile {

	public static void downloadFile(String url, String filename) throws MalformedURLException{
		String name = FilenameUtils.getBaseName(url);
		String ext = FilenameUtils.getExtension(url);
		String fullname = name+"."+ext;
		try {
			URL ur = new URL(url);
			File finishedfile = new File("downloads/" + fullname);
			FileUtils.copyURLToFile(ur,finishedfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
