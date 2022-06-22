package com.OrangeHRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DataHandlersPropertiesFile {

	static File f;
	static FileInputStream fis;
	static FileOutputStream fos;
	static Properties prop;
	
	
	
	public static String readDataFromPropertiesFile(String filePath, String key) throws IOException {
		
		f = new File(filePath);
		fis = new FileInputStream(f);
		prop = new Properties();
		prop.load(fis);
		String data = (String) prop.get(key);
		System.out.println("data from config file" +data);
		return data;
	}
	
	
public static void writeDataToPropertiesFile(String filePath, String key, String value, String comments) throws IOException {
		
		f = new File(filePath);
		fis = new FileInputStream(f);
		prop = new Properties();
		prop.load(fis);
		prop.setProperty(key, value);
		fos = new FileOutputStream(f);
		prop.store(fos, comments);
	}
}
