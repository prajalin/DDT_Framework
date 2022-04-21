package Constant;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
	public static WebDriver driver;
	//public static String url = "http://orangehrm.qedgetech.com";
	@BeforeTest
	public static void launchApp()
	{
		System.setProperty("webdriver.chrome.driver","./CommonDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//driver.get(url);
	}
	@AfterTest
	public static void closeApp()
	{
		driver.close();
	}
	

}
