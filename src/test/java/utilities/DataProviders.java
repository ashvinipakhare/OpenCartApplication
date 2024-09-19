package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException, InterruptedException
	{
		String path="D:\\Eclips\\OpenCartApplication\\testData\\testData.xlsx";  //taking x1 file from testData
		ExcelUtility xlutil=new ExcelUtility(path); //Creating an object  for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols]; //created for two dimension array
		Thread.sleep(5000);
		
		for(int i=1;i<=totalrows;i++) //1 //read the data from xl sorting in two dimensional array
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getcellData("Sheet1",i,j);  //1,0S
			}
		} 
		return logindata;  //retuning two dimension array	
	}
	
 
}
















































































































