package com.jahia.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class Util {

	public static final Properties properties = new Properties();
	public static InputStream input = null;
	
	public static void initPropertySetup() {
		try {
			input = new FileInputStream("config.properties");
			properties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
