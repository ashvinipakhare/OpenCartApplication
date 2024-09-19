package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement textEmail;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPwd;
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkPolicy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confimationMSG;
	
	public void setFirstname(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public void setLastname(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		textEmail.sendKeys(email);
	}
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void setConPassword(String pwd)
	{
		txtConfirmPwd.sendKeys(pwd);
	}
	public void checkPolicy()
	{
		checkPolicy.click();
	}
	public void clickContinueBtn()
	{
		btnContinue.click();
		//btnContinue.submit();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return(confimationMSG.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
	

}
