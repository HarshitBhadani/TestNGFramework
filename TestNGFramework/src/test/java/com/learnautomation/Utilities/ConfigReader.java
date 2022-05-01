package com.learnautomation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;
	public ConfigReader() {
		File file = new File("./config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			this.prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		return this.prop.getProperty("Browser");
	}

	public String getAppUrl() {
		return this.prop.getProperty("appUrl");
	}
}
