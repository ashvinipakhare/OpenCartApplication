package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass
{
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProvider.class, groups="DataDriven")//getting data provider from the diffrent class & package
	public void verify_loginDDT(String userename, String password, String exp) throws InterruptedException
	{
		Thread.sleep(5000);
		try
		{
		//Home Page
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickOnLogin();
				
				
				//Login Page
				LoginPage lp=new LoginPage(driver);
				
				lp.setEmailAddress(userename);
				lp.setPassword(password);
				lp.clickLogin();
				
				//MyAccount Page
				MyAccountPage macc=new MyAccountPage(driver);
				boolean targetPage=macc.isMyaccountPageExists();
				
				
				
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetPage==true)
					{
						macc.clickOnLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
					
				}
				if(exp.equalsIgnoreCase("Invalid"))
				{
					if(targetPage==true)
					{
						macc.clickOnLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				
	            }
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	
	}
}
