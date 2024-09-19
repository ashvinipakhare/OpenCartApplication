package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
		
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement headingMsg;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement logoutBtn;
	
	public boolean isMyaccountPageExists()
	{
		try
		{
			return(headingMsg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickOnLogout()
	{
		logoutBtn.click();
	}
	
	

}
