package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Utilities.TestUtil;

public class LoginTest extends TestBase {

	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(5000);
		/***Check it takes all values********
		System.out.println(or.getProperty("txtun"));
		System.out.println(or.getProperty("txtpwd"));
		System.out.println(or.getProperty("btnlogin"));
		*/
		Log.debug("Inside Login Test....");
		System.out.println("In Login Test");
	
		driver.findElement(By.xpath(or.getProperty("txtun"))).sendKeys("Admin");
		driver.findElement(By.xpath(or.getProperty("txtpwd"))).sendKeys("admin");
		driver.findElement(By.id(or.getProperty("btnlogin"))).click();
		Thread.sleep(2000);
		Assert.assertTrue(isElementPresent(By.id(or.getProperty("verifywelcome"))),"Login not successful!!!");
		//Add to report
		Reporter.log("Login Successfully....");
	}
	//Createuser Test
		@Test(dataProvider="getdata")
		public void test2(String userrole,String empname, String un,String status,String pwd,String cpwd) throws InterruptedException, IOException{
			Thread.sleep(7000);
			System.out.println(driver.getTitle());
			System.out.println("In Create user Test");
			driver.findElement(By.linkText("Admin")).click();
			Thread.sleep(2000);
				
			driver.findElement(By.id("menu_admin_UserManagement")).click();
			Thread.sleep(2000);
			driver.findElement(By.id(or.getProperty("btnadd"))).click();
			Thread.sleep(2000);
			//Select s = new Select(driver.findElement(By.id("systemUser_userType")));
			//s.selectByValue("1");
			//driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empname);
			//driver.findElement(By.id("systemUser_userName")).sendKeys(un);
			//driver.findElement(By.id("systemUser_status")).sendKeys(status);
			
			//driver.findElement(By.id("systemUser_password")).sendKeys(pwd);
			//driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(cpwd);
			
			
			//System.out.println(driver.findElement(By.id(or.getProperty("usertype"))));
			WebElement usertype = driver.findElement(By.id(or.getProperty("usertype")));
			Select userrol = new Select(usertype);
			userrol.selectByValue("1");
			driver.findElement(By.id(or.getProperty("empname"))).sendKeys(empname);
			driver.findElement(By.id(or.getProperty("username"))).sendKeys(un);
			
			driver.findElement(By.id(or.getProperty("status"))).sendKeys(status);
			driver.findElement(By.id(or.getProperty("password"))).sendKeys(pwd);
			driver.findElement(By.id(or.getProperty("cpassword"))).sendKeys(cpwd);
			
			//click Save
			driver.findElement(By.id(or.getProperty("btnsave"))).click();
			//Report
			Reporter.log("User added successfully....");
			Assert.fail("User fail to add");
			TestUtil.captureScreenshot();
		}
		//Logout Test
		@Test
		public void test3() throws InterruptedException{
			Thread.sleep(7000);
			/***Check it takes all values*******
			System.out.println(or.getProperty("verifywelcome"));
			System.out.println(or.getProperty("logout"));
			*/
			System.out.println("Login done.....");
		
			Log.debug("Login  Successfully....");
			
			driver.findElement(By.id(or.getProperty("verifywelcome"))).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText(or.getProperty("logout"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(isElementNotPresent(By.id(or.getProperty("verifywelcome"))),"Logout successful!!!");
			
			System.out.println("Logout");
			Reporter.log("Logout Successfully...");
		}
		@DataProvider
		public Object[][] getdata(){
			String sheetname="createuser";
			int rows=excel.getRowCount(sheetname);
			System.out.println("Row count "+rows);
			int cols=excel.getColumnCount(sheetname);
			System.out.println("Col count "+cols);
			Object[][] data = new Object[rows-1][cols];
			
			for(int rownum=2;rownum<=rows;rownum++){
				for(int colnum=0;colnum<cols;colnum++){
					//data[0][0]
					data[rownum - 2][colnum]=excel.getCellData(sheetname, colnum, rownum);
				}
				
			}
			
			return data;
		
			
		}
	

}
