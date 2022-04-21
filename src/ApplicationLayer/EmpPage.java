package ApplicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmpPage 
{

	@FindBy(id="menu_pim_viewPimModule")
	WebElement objpim;
	@FindBy(id="btnAdd")
	WebElement objAddbtn;
	@FindBy(id="firstName")
	WebElement objfname;
	@FindBy(id="lastName")
	WebElement objlname;
	@FindBy(id="btnSave")
	WebElement objsavebtn;
	//method for adding employee
	public void verifyAddEmp(String fname,String lname) throws Throwable
	{
		objpim.click();
		Thread.sleep(3000);
		objAddbtn.click();
		Thread.sleep(3000);
		objfname.sendKeys(fname);
		objlname.sendKeys(lname);
		objsavebtn.click();
	}

}
