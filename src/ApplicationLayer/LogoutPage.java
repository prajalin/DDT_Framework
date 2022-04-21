package ApplicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage 
{
	@FindBy(id="welcome")
	WebElement clickWelcome;
	@FindBy(linkText="Logout")
	WebElement clickLogout;
	// method for logout
	public void verifyLogout() throws Throwable
	{
		clickWelcome.click();
		Thread.sleep(3000);
		clickLogout.click();
		
	}
	

}
