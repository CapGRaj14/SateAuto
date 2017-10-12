package TestScripts;

import org.testng.annotations.Test;

import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.GenericClass;

public class TC021_CaseManagementNotes extends DriverScript
{
	
	public static String TCID="CV_TC021";
	public static String DataTable = "CV_REG";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties";
	public static String testCaseName="Case Management Notes";
	public static String uri = "ws://localhost:5095";
	
	 @Test
	
	    public static void tc021() throws Throwable
	 {
		//LeanfT SDK configurations..
		 GenericClass.sdkConfig(uri);
		//Loading MS access DB.
		 DBnBrowserloading(TCID,DataTable);	
		//Initializing browser with the active screen.
		 browser = GenericClass.createActiveScreenBrowser();
			
		ReportEvent.testStepReport("", "Info", testCaseName);
		
		
		//Step-123
		BenefitClaimedPage_CV.clickingCustomLinkOfBenefitClaimedPage(browser, "Case Management");
		BenefitClaimedPage_CV.confirmingCaseManagementPageNavigation(browser);
		
		//Step-124
		
		BenefitClaimedPage_CV.clickTabCaseMgmt("", browser, "Medical");
		
		//Step-125
		
		BenefitClaimedPage_CV.clickAddNoteLink(testCaseName, browser);
		Thread.sleep(5000);
		BenefitClaimedPage_CV.validateProclaimNumberAndUpdation(testCaseName, browser, "ProClaim Number: 00EZ2468.", "Test input value");
		
		//Step-126
		BenefitClaimedPage_CV.clickButtonOfMedicalSec(testCaseName, browser, "Save");
		
	 }

}
