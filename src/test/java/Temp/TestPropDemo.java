package Temp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Create a Properties class for config & OR files
				Properties config = new Properties();
				Properties or = new Properties();
				
				//FileInputStream
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
				
				//to get project path-C:\\Users\\Nilesh\\demo\\DatadrivenFramework
				//System.out.println(System.getProperty("user.dir"));
				
				//load file
				config.load(fis);
				
				//get values of browser and testurl
				System.out.println(config.getProperty("browser"));
				System.out.println(config.getProperty("testurl"));
				
				//-----------------From OR file-----------------------------
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
				//load file
				or.load(fis);
				//get values
				System.out.println(or.getProperty("txtun"));
				
	}

}
