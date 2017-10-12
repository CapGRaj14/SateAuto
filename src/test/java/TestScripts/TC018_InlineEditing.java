package TestScripts;

import org.testng.annotations.Test;

import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.GenericClass;

public class TC018_InlineEditing extends DriverScript
{
	
	public static String TCID="CV_TC018";
	public static String DataTable = "CV_REG";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties";
	public static String testCaseName="In-Line editing";
	public static String uri = "ws://localhost:5095";
	
	 @Test
	
	    public static void tc018() throws Throwable
	 {
		//LeanfT SDK configurations..
		 GenericClass.sdkConfig(uri);
		//Loading MS access DB.
		 DBnBrowserloading(TCID,DataTable);	
		//Initializing browser with the active screen.
		 browser = GenericClass.createActiveScreenBrowser();
			
		ReportEvent.testStepReport("", "Info", testCaseName);
		
		//Step-105..
		//Inline update of policy id..
		BenefitClaimedPage_CV.inlineEditingOfPolicyID(testCaseName, browser, "Policy", "121216", "121214");
		
		//Step-106
		//clicking Save button..
		BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName, browser, "Save");

		Thread.sleep(4000);
		BenefitClaimedPage_CV.validateFieldValueWithInputValueOfPolicySection(testCaseName, browser, "Policy", "121214");
	 
		
		 /*Capturing the screenTitle of Last page of TC and then saving it in appData.properties file*/
		String screentitle=browser.getTitle();
		GenericClass.setActiveScreenTitleInConfigFile(screentitle);

	 
	 }
	 

}


