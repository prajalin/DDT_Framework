package ApplicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	// store locators
	@FindBy(name="txtUsername")
	WebElement objusername;
	@FindBy(id="txtPassword")
	WebElement objpassword;
	@FindBy(name="Submit")
	WebElement objlogin;
	// method for login
	public void verifyLogin(String username,String password)
	{
		objusername.sendKeys(username);
		objpassword.sendKeys(password);
		objlogin.click();
	}

}
