package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Utilities.ExcelReader;

public class TestBase {

public static WebDriver driver;
public static Properties config  = new Properties();
public static Properties or = new Properties();
public static FileInputStream fis;
public static Logger Log = Logger.getLogger("devpinoyLogger");
public static ExcelReader excel = new ExcelReader("D:\\Oxygen\\DataDrivenFramework\\src\\test\\resources\\Excel\\TestData.xlsx");

@BeforeSuite 
public void setUp() {
	if(driver==null) 
	{ 
		
	try {
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	try {
		config.load(fis);
		Log.debug("Config file is loaded......");
	}catch(IOException e1) 
	{
		e1.printStackTrace();
	}
	try {
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.Properties");
	}catch(FileNotFoundException e1) {
		e1.printStackTrace();
	}
	try {
		or.load(fis);
		Log.debug("OR file is loaded......");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	if (config.getProperty("browser").equals("Firefox")) {
		System.out.println(config.getProperty("browser"));
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\geckodriver.exe");
		driver = new FirefoxDriver();
		Log.debug("Firefox is launched......");
	}else if(config.getProperty("browser").equals("Chrome")) {
		System.out.println(config.getProperty("browser"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");
		driver = new ChromeDriver();
		Log.debug("Chrome is launched......");
	}else if(config.getProperty("browser").equals("IE")) {
		System.out.println(config.getProperty("browser"));
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		Log.debug("IE is launched......");
	}else if(config.getProperty("broser").equals("Edge")) {
		System.out.println(config.getProperty("browser"));
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		Log.debug("Edge is launched......");
	}
	driver.get(config.getProperty("testurl"));
	Log.debug("URL is loaded....."+config.getProperty("testurl"));
	}
 }
public boolean isElementPresent(By by) {
	try {
		driver.findElement(by);
		return true;
		}catch(NoSuchElementException e) {
		return false;
		}
	}
public boolean isElementNotPresent(By by) {
	try {
		driver.findElement(by);
		return false;
		}catch(NoSuchElementException e) {
		return true;
	}
}

@AfterSuite
public void tearDown() {
	if(driver!=null) {
		driver.quit();
	}
	Log.debug("Test Execution Completed!!!");
	
}

}
