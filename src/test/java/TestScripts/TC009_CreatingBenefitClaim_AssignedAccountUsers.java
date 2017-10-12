package TestScripts;

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.Properties;

import org.testng.annotations.Test;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.sic.accelerators.ActionEngine_Web;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.GenericClass;

public class TC009_CreatingBenefitClaim_AssignedAccountUsers extends DriverScript {
	
	public static String TCID="CV_002";
	public static String DataTable = "CV_REG";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties"; 
	public static String testCaseName ="Creating Benefit Claim Assigned Account User";
	public static String uri = "ws://localhost:5095";
	 @Test
	
	    public static void tc09() throws Throwable{
		 

		 /*ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		 config.setServerAddress(new URI("ws://localhost:5095"));
	     SDK.init(config);
	     */

	//LeanfT SDK configurations..
	     GenericClass.sdkConfig(uri);
	//Initializing browser with the active screen.
		 browser = GenericClass.createActiveScreenBrowser();
	//Loading MS access DB.
		 DBnBrowserloading(TCID, DataTable);
		 
	// Loading the config.properties file..
		 File f = new File(configFilepath);
		 FileReader fr = new FileReader(f);
		 Properties prop = new Properties();
		 prop.load(fr);
		
		 
	//Saving the generated BC Claim ID into config.properties file and assigning the value to a string variable.
	
		 GenericClass.saveGeneratedDataInConfigFile(browser, "Benefit Claimed", "benefitID");
		 String  benefitClaimedID=prop.getProperty("benefitID");
		 
	//Step 48	 
		 
	/*Benefit claim ID page navigation..*/
		 BenefitClaimedPage_CV.confirmingBenefitClaimedIdPageNavigation(testCaseName,browser, "Benefit Claimed", benefitClaimedID);
	/*verifying column values of open activities section..*/
		 

		 BenefitClaimedPage_CV.verifyingColumnValueOFOpenActivitySec(testCaseName,browser, 

													rd.getCellData(DataTable, "OpenActivity_SubjectValue", TCID),
													rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
													rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
													rd.getCellData(DataTable, "OpenActivity_AssignUser", TCID));
	/*Validating due business days*/

		  BenefitClaimedPage_CV.validatingDueBusinessDays(testCaseName,browser, Integer.parseInt(rd.getCellData(DataTable, "OpenActivity_5BusinesDays", TCID)),

																			rd.getCellData(DataTable, "OpenActivity_IncompleteSubject", TCID),
																			rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
																			rd.getCellData(DataTable, "OpenActivity_LastModifedHeader", TCID),
																			rd.getCellData(DataTable, "OpenActivity_DueDateHeader", TCID));
	/*Verifying Benefit Claimed section on sidebar */
		  BenefitClaimedPage_CV.verifyingLInksInCurrentBenefitClaimedSideBar(browser, benefitClaimedID);
		  
	/*Capturing the screenTitle of Last page of TC and then saving it in appData.properties file*/
		  String screentitle=browser.getTitle();
		  GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	
	 }
}
