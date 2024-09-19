package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationPage extends BaseClass
{
	
	@Test(groups={"Regression" ,"Master"})
	public void verify_account_registration() throws InterruptedException 
	{
		try
		{
		logger.info("**** Starting the test TC_001_AccountRegistrationPage *****");
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("clicked on My Account link");
		
		
		hp.clickRegister();
		logger.info("clicked on Register link");

		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing custmer details");
		Thread.sleep(3000);
		regpage.setFirstname(randomeString().toUpperCase());
		regpage.setLastname(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphanumric();
		regpage.setPassword(password);
		regpage.setConPassword(password);
		regpage.checkPolicy();
		regpage.clickContinueBtn();
		
		logger.info("validationg confirmation message");
		String conMSG=regpage.getConfirmationMsg();
		if(conMSG.equals("Your Account Has Been Created!"))
		{
			logger.error("Test Failed....");
			logger.debug("Debug logs....");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
			
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("**** Finished the test TC_001_AccountRegistrationPage *****");
		
		
	}
	
	
	

}
