package com.sic.base;

import java.net.URI;
import java.util.TreeMap;

import org.testng.annotations.AfterClass;
import org.testng.asserts.SoftAssert;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.Browser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sic.accelerators.ActionEngine;
import com.sic.accelerators.StdWinActionEngine;
import com.sic.accelerators.TestEngine;
import com.sic.support.ExtentManager;
import com.sic.support.ReportEvent;
import com.sic.utilities.BrowserFactoryTest;
import com.sic.utilities.ReadData;

import com.sic.utilities.utility;



public class DriverScript_Desktop  extends StdWinActionEngine {
		
	public static ReadData rd = new ReadData();
	public static ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;
	public static Browser browser = null;
	public static Process appWinDim;
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
									ReportEvent.testStepReport(tTestCaseName, "Info", "Starting the test");
								
									try {

										ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
										config.setServerAddress(new URI("ws://localhost:5095"));
										SDK.init(config);
		    							appWinDim = new ProcessBuilder(TestEngine.loadEnvironment(System.getProperty("test.env"), ".DUrl")).start();
		    							System.out.println("Application is opening");
		    				} catch (Throwable t) {
		    							System.out.println("Exception for AIT to start : "+t.getMessage());
		    							utility.fnLogging("Exception for AIT to start : "+t.getMessage());
		    				}
    				}
						
						isExecutable= true;	
						
				return isExecutable;
				
			}

	
		public static final int countOfExecutableTestCases = 2;

   /* @AfterClass
    		public void afterClass() throws Throwable {
    	
    	if (browser != null) {
			rd.closeConnection();
			browser.close();
			ReportEvent.testStepReport(tTestCaseName, "Info", "Ending the test");

		}

		if (errorCount != 0) {
			System.out.println("Count of total error count after all test script run : " + errorCount);
			utility.fnLogging("Count of total error count after all test script run : " + errorCount);
			// softAssert.assertAll();
			utility.fnLogging("Value of errorCount is " + errorCount);
		}
	}*/


	}
