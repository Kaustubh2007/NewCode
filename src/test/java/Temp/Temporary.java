package Temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Temporary {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();

		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Admin")).click();
		Thread.sleep(2000);
		try{
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		}
		catch(Exception e){
			System.out.println(e);//Thread.sleep(3000);
		}
		//driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
		Thread.sleep(3000);
        driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		
        driver.quit();
	}

}
