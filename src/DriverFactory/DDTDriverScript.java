package DriverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Constant.AppUtil;
import Utilities.ExcelFileUtil;


public class DDTDriverScript extends AppUtil {
	
	String inputpath = "C:\\Users\\CANVAS\\eclipse-workspace\\DDT_FrameWork\\TestInput\\LoginData.xlsx";
	String outputpath = "C:\\Users\\CANVAS\\eclipse-workspace\\DDT_FrameWork\\TestOutput\\DDTResults.xlsx";
	@Test
	public void verifyLogin()throws Throwable
	{
		//create reference object
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		//count no of rows in sheet
		int rc = xl.rowCount("Login");
		Reporter.log("no of rows in a sheet::"+ rc, true);
		//iterate all rows to get column data
		for(int i=1;i<=rc;++i)
		{
			driver.get("http://orangehrm.qedgetech.com");
			//read username and password cells
			String username = xl.getCellData("Login", i, 0);
			String password = xl.getCellData("Login", i, 1);
			driver.findElement(By.name("txtUsername")).sendKeys(username);
			driver.findElement(By.name("txtPassword")).sendKeys(password);
			driver.findElement(By.name("Submit")).click();
			String expected = "dashboard";
			String actual = driver.getCurrentUrl();
			if(actual.contains(expected))
			{
				Reporter.log("login successful",true);
				//write login successful in results cell
				xl.setCellData("Login", i, 2,"login successful",outputpath );
				//write pass in status cell
				xl.setCellData("Login", i, 3,"pass",outputpath);
			}
			else
			{
				//take screen shot
				File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("./screens/Iteration/"+i+"Login.png"));
				//capture error message
				String errormessage = driver.findElement(By.id("spanMessage")).getText();
				Reporter.log("login failed",true);
				//write login failed in results cell
				xl.setCellData("Login", i, 2, errormessage, outputpath);
				//write fail in status cell
				xl.setCellData("Login", i, 3, "fail", outputpath);
				
			}
			
			
		}
		
	}
	

}
