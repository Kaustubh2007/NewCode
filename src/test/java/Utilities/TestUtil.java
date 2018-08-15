package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.TestBase;

public class TestUtil extends TestBase{
	
	public static String screenshotpath;
	public static String screenshotname;
	
	public static void captureScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotname = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotname));
	}

}
