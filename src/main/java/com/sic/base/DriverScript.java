package com.sic.base;

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.Properties;
import java.util.TreeMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sic.accelerators.ActionEngine_Dialog;
import com.sic.accelerators.ActionEngine_Web;
import com.sic.accelerators.TestEngine;
import com.sic.support.ExtentManager;
import com.sic.support.ReportEvent;
import com.sic.utilities.BrowserFactoryTest;
import com.sic.utilities.ReadData;

import com.sic.utilities.utility;



public class DriverScript  extends ActionEngine_Web {
		
	public static ReadData rd = new ReadData();
	public static ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;
	public static Browser browser = null;
	
	public static String msAccDBName;
	public static String tTestCaseName;
	public static String tExecute;
	public static String tTestCaseID;
	public static SoftAssert softAssert;
	public static int errorCount=0;
	
	static TreeMap<Integer,String> executableTCIndex=new TreeMap<Integer,String>();

	public static boolean isTestCaseRunnable(String TCID,String DataTable) throws Throwable{
		boolean isExecutable=false;
		msAccDBName = TestEngine.loadEnvironment(System.getProperty("test.env"), ".DB");
		System.out.println(msAccDBName);
		rd.DBConnection(msAccDBName);
		tTestCaseID = rd.getCellData(DataTable, "tTestCaseID", TCID);
		tExecute = rd.getCellData(DataTable, "tExecute", TCID);
		tTestCaseName = rd.getCellData(DataTable, "tTestCaseDescription", TCID);
		
		//String url=  xls.getCellData("Test Cases", "Url", rowNum);
		if (tExecute != null) {
							ReportEvent.testStepReport(tTestCaseName, "Info", "Starting the "+System.getProperty("test.type")+" test in "+utility.fnReadPropFile("browserName")+" browser");
						
							browser = BrowserFactoryTest.fnOpenBrowser(browser);
							handleDialogue(browser);		
					    			}else{
					    							System.out.println("Please make sure 'AUT_To_Start' flag to 'Y' in your datasheet, if you want to start the application");
					    							utility.fnLogging("Please make sure 'AUT_To_Start' flag to 'Y' in your datasheet, if you want to start the application");
					    			}
				
				browser.navigate(TestEngine.loadEnvironment(System.getProperty("test.env"), ".Url"));
				
				isExecutable= true;	
				
		return isExecutable;
		
	}


			private static void handleDialogue(Browser browser2) {
		// TODO Auto-generated method stub
		
	}


			public static boolean DBnBrowserloading(String TCID,String DataTable) throws Throwable{
				boolean isExecutable=false;
				msAccDBName = TestEngine.loadEnvironment(System.getProperty("test.env"), ".DB");
				System.out.println(msAccDBName);
				rd.DBConnection(msAccDBName);
				tTestCaseID = rd.getCellData(DataTable, "tTestCaseID", TCID);
				tExecute = rd.getCellData(DataTable, "tExecute", TCID);
				tTestCaseName = rd.getCellData(DataTable, "tTestCaseDescription", TCID);
				
			
				
		  /*  	if(!title.isEmpty()){
		    		String brTitle = brs[brs.length-1].getTitle();
		    		browser =brs[brs.length-1];
		    		browser = BrowserFactoryTest.fnOpenBrowser(browser);
		    		Thread.sleep(10000);
					browser.close();
					Thread.sleep(3000);
		    		browser=BrowserFactory.attach(new BrowserDescription.Builder().title(title).build()); 
			    	browser.highlight();
		    	}else{
		    		ReportEvent.testStepReport(tTestCaseName, "Info", "Starting the "+System.getProperty("test.type")+" test in "+utility.fnReadPropFile("browserName")+" browser");
					browser = BrowserFactoryTest.fnOpenBrowser(browser);
					Thread.sleep(10000);
					browser.navigate(TestEngine.loadEnvironment(System.getProperty("test.env"), ".Url"));
		    	}*/
		    	
		    	
						
						isExecutable= true;	
						
				return isExecutable;
				
			}
	
		public static final int countOfExecutableTestCases = 2;

    @AfterClass
    		public void afterClass() throws Throwable {
    	
    	if (browser != null) {
			rd.closeConnection();
			//browser.close();
			ReportEvent.testStepReport(tTestCaseName, "Info", "Ending the test");

		}

		if (errorCount != 0) {
			System.out.println("Count of total error count after all test script run : " + errorCount);
			utility.fnLogging("Count of total error count after all test script run : " + errorCount);
			// softAssert.assertAll();
			utility.fnLogging("Value of errorCount is " + errorCount);
		}
	}

    @BeforeMethod
    public static Browser createActiveScreenBrowser()
	{
		try
		{
			String path = System.getProperty("user.dir");	
			File f = new File(path+"\\appData.properties");
			FileReader fr = new FileReader(f);
			Properties prObj = new Properties();
			prObj.load(fr);
			BrowserDescription br = new BrowserDescription();
			Browser[] b= BrowserFactory.getAllOpenBrowsers(br);
			for(int i=0;i<b.length;i++)
	    	{
	    		String openBrowserTitle =b[i].getTitle();
	    		if(openBrowserTitle.equals(prObj.getProperty("activeScreenTitle")))
	    		{
	    			browser = b[i];
	    			browser.highlight();
	    			break;
	    		}
	    		else
	    		{
	    			continue;
	    		}
	    	}
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
		return browser;
				
	}
    

public static void sdkConfig()
{
	try
	{
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		 config.setServerAddress(new URI("ws://localhost:5095"));
	     SDK.init(config);
	}
	catch(Throwable t)
	{
	ReportEvent.testStepReport("", "Fail", "Exception is "+ t.getMessage() );	
	}
	
}
    

	}
