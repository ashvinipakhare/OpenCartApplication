package utilities;

import java.text.SimpleDateFormat;
import java.awt.Desktop;
import java.awt.desktop.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtenntReportManagement implements ITestListener
{
	public ExtentSparkReporter sparkReporter; //Responsible for creating the look and feel of the report
	public ExtentReports extent;    //populate common information of the report(who execute test etc)
	public ExtentTest test;   //Create test case entry into the report and update status of the test cases
	
	String repName;
	
	public void onStart(ITestContext context) 
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currentdatetimestamp=df.format(dt);
		
		
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" +timestamp + ".html";
		
	    sparkReporter=new ExtentSparkReporter("D:\\Eclips\\OpenCartApplication\\reports\\repName");
	    File directory = new File("D:\\Eclips\\OpenCartApplication\\reports\\repName");
	    if (!directory.exists()) {
	        directory.mkdirs();
	    }
	    
	    sparkReporter.config().setDocumentTitle("opencart Automation Report"); //Title of the report
	    sparkReporter.config().setReportName("opencart Functional Testing"); //Name of the report
	    sparkReporter.config().setTheme(Theme.DARK);
	    
	    
	    extent=new ExtentReports();
	    extent.attachReporter(sparkReporter);	    
	 	extent.setSystemInfo("Application", "opencart");
	    extent.setSystemInfo("Module", "Admin");
	    extent.setSystemInfo("Sub Module", "Customers");
	    extent.setSystemInfo("User Name",System.getProperty("user.name"));
	    extent.setSystemInfo("Environment", "QA");
	    
	    String os=context.getCurrentXmlTest().getParameter("os");
	    extent.setSystemInfo("Operating System" , os);
	    
	    String browser = context.getCurrentXmlTest().getParameter("browser");
	    extent.setSystemInfo("Browser", browser);
	    
	   List<String> includedGroups =context.getCurrentXmlTest().getIncludedGroups();
	   if(!includedGroups.isEmpty()) 
	   {
		   extent.setSystemInfo("Groups", includedGroups.toString());
	   }

	}
	
	public void onTestSuccess(ITestResult result) 
	{
		test = extent.createTest(result.getTestClass().getName()); //create new entry into the report
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+ "Got successfully executed"); //Update status p/f/s
	}
	
	
	public void onTestFailure(ITestResult result) 
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL,result.getName()+ "Got failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		try
		{
			String imgPath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.SKIP, result.getTestName() +"Got Skipped");
		test.log(Status.INFO,result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext context) 
	{
		extent.flush();
		
		String pathofExtentReport = System.getProperty("user.dir") +"\\trports\\"+repName;
		File extentReport = new File(pathofExtentReport);
		
		try
		{
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	

}



























































