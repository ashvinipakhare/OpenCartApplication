package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginPage extends BaseClass
{
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		try
		{
		//Home Page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickOnLogin();
		
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount Page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyaccountPageExists();
		
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		
		
		
		
	}
	
	
	

}
