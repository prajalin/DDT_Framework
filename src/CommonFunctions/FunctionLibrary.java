package CommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Constant.PBAppUtil;

public class FunctionLibrary extends PBAppUtil {
	//method for login
	public static boolean verifyLogin(String username, String password) throws Throwable
	{
		driver.findElement(By.name("txtuId")).sendKeys(username);
		driver.findElement(By.name("txtPword")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		String expected = "adminflow";
		String actual = driver.getCurrentUrl();
		if(actual.toLowerCase().contains(expected.toLowerCase()))
		{
			Reporter.log("login success"+ expected+"  "+actual);
			return true;
		}
		else
		{
			Reporter.log("login failed"+ expected+"  "+actual);
			return false;
			
		}
	}
	//method for click Branches
	public static void clickBranches()throws Throwable
	{
		driver.findElement(By.xpath("(//img)[5]")).click();
		Thread.sleep(4000);
		
		
	}
	//method for Branch Creation
	public static boolean verifyNewBranch(String bname,String address1,String address2,String address3,String area,String zipcode,String country,String state,String city) throws Throwable
	{
		driver.findElement(By.xpath("//input[@id='BtnNewBR']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("txtbName")).sendKeys(bname);
		driver.findElement(By.name("txtAdd1")).sendKeys(address1);
		driver.findElement(By.name("Txtadd2")).sendKeys(address2);
		driver.findElement(By.name("txtadd3")).sendKeys(address3);
		driver.findElement(By.name("txtArea")).sendKeys(area);
		driver.findElement(By.name("txtZip")).sendKeys(zipcode);
		new Select(driver.findElement(By.name("lst_counrtyU"))).selectByVisibleText(country);
		Thread.sleep(3000);
		new Select(driver.findElement(By.name("lst_stateI"))).selectByVisibleText(state);
		Thread.sleep(3000);
		new Select(driver.findElement(By.name("lst_cityI"))).selectByVisibleText(city);
		Thread.sleep(3000);
		driver.findElement(By.name("btn_insert")).click();
		Thread.sleep(3000);
		//capture alert message
		String branchalert = driver.switchTo().alert().getText();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String expected = "New Branch with";
		if(branchalert.toLowerCase().contains(expected.toLowerCase()))
				{
			       Reporter.log("Branch creation success::"+ branchalert+"  "+expected,true);
			       return true;
				
				}
		else
		{
			 Reporter.log("Branch creation failed::"+ branchalert+"  "+expected,true);
			 return false;
			
		}
		
		
	}
	//method for Branch Updation
	public static boolean verifyBranchUpdate(String branchname,String address,String zip) throws Throwable
	{
		driver.findElement(By.xpath("(//td[normalize-space()='Edit'])[1]")).click();
		Thread.sleep(3000);
		WebElement branch = driver.findElement(By.name("txtbnameU"));
		branch.clear();
		branch.sendKeys(branchname);
		Thread.sleep(3000);
		WebElement address1 = driver.findElement(By.name("txtadd1u"));
		address1.clear();
		address1.sendKeys(address);
		Thread.sleep(3000);
		WebElement zipcode = driver.findElement(By.name("txtzipu"));
		zipcode.clear();
		zipcode.sendKeys(zip);
		Thread.sleep(3000);
		// capture alert message
		String actualAlertupdate = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String expected = "Branch updated";
		if(actualAlertupdate.toLowerCase().contains(expected.toLowerCase()))
		{
			Reporter.log(actualAlertupdate,true);
			return true;
		}
		else
		{
			Reporter.log(actualAlertupdate,true);
			return false;
			
		}
		
	}
	// method for Logout
	public static boolean verifyLogout()throws Throwable
	{
		driver.findElement(By.xpath("(//img)[4]")).click();
		Thread.sleep(3000);
		if(driver.findElement(By.name("login")).isDisplayed())
		{
			Reporter.log("logout success", true);
			return true;
		}
		else
		{
			Reporter.log("logout failed",true);
			return true;
			
		}
	}
	

}
