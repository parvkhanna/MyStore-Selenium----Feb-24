package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	String path = (System.getProperty("user.dir") + "\\Configuration\\config.properties");
	
	public ReadConfig()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public String getBaseUrl()
	{
		String url = prop.getProperty("url");
		
		if(url != null)
			return url;
		else {
			throw new RuntimeException("Url not specified in config File");
		}
	}
	
	public String getBrowser()
	{
		String browser = prop.getProperty("browser");
		
		if(browser != null)
			return browser;
		else {
			throw new RuntimeException("Browser not specified in config File");
		}
	}
	
	
}
