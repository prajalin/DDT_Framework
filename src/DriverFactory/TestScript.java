package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ApplicationLayer.EmpPage;
import ApplicationLayer.LoginPage;
import ApplicationLayer.LogoutPage;
import ApplicationLayer.UserPage;

public class TestScript 
{
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./CommonDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		LoginPage login =PageFactory.initElements(driver, LoginPage.class);
		login.verifyLogin("Admin","Qedge123!@#");
		
	}
	@Test(priority=0)
	public void userModule() throws Throwable
	{
		UserPage user =PageFactory.initElements(driver, UserPage.class);
		user.verifyAddUser("badra pitchika", "Akhilesh90", "Selenium@123456", "Selenium@123456");
		
	}
	@Test(priority=1)
	public void empModule() throws Throwable
	{
		EmpPage emp =PageFactory.initElements(driver,EmpPage.class);
		emp.verifyAddEmp("Akhilesh", "Ranga");
		
	}
	@AfterMethod
	public void tearDown() throws Throwable
	{
		LogoutPage logout =PageFactory.initElements(driver, LogoutPage.class);
		logout.verifyLogout();
		driver.quit();
	}

}
