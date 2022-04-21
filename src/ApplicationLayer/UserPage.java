package ApplicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage 
{
	// store locators
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement objAdmin;
	@FindBy(name="btnAdd")
	WebElement objAdd;
	@FindBy(name="systemUser[employeeName][empName]")
	WebElement objEname;
	@FindBy(name="systemUser[userName]")
	WebElement objUser;
	@FindBy(name="systemUser[password]")
	WebElement objPass;
	@FindBy(name="systemUser[confirmPassword]")
	WebElement objCpass;
	@FindBy(name="btnSave")
	WebElement objSavebtn;
	// method for adding user
	public void verifyAddUser(String ename,String user,String pass,String cpass) throws Throwable
	{
		objAdmin.click();
		Thread.sleep(3000);
		objAdd.click();
		Thread.sleep(3000);
		objEname.sendKeys(ename);
		objUser.sendKeys(user);
		objPass.sendKeys(pass);
		Thread.sleep(3000);
		objCpass.sendKeys(cpass);
		Thread.sleep(3000);
		objSavebtn.click();
	}
	
	

}
