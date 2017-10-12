package TestScripts;

import java.net.URI;

import org.testng.annotations.Test;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.sic.base.DriverScript;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.GenericClass;
import PageObjects.LoginPage_CV;

public class TC032_Rollover_To_LTD extends DriverScript{
	
	public static String TCID="CV_001";
	public static String DataTable = "CV_REG";
	public static String testCaseName ="TC032_Rollover_To_LTD";
	public static String uri ="ws://localhost:5095";
	
	@Test
	
    public static void tc032() throws Throwable
 {
		
		
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		config.setServerAddress(new URI( uri));
	    SDK.init(config);
	    
	 browser = GenericClass.createActiveScreenBrowser();
	 DBnBrowserloading(TCID, DataTable);
	 
//Step 168
/*	 
//*** Click Edit button
		BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName, browser,"Edit" rd.getCellData(DataTable, "Edit_Button", TCID));
//*** Confirm BC edit page navigation..
		BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(testCaseName,browser);
	 
//*** Update status reason to Roller to LTD..
		BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(testCaseName,browser,"Status Reason"rd.getCellData(DataTable, "StatusReason_Label", TCID),"Rollover to LTD"
																						rd.getCellData(DataTable, "StatusReason_RollerToLTD", TCID));
//*** Click save button
    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(testCaseName,browser,"Save" rd.getCellData(DataTable, "Save_Button", TCID));
		*/
//*** Function for list of records availabily in open activity section..
    	//BenefitClaimedPage_CV.checkingRecordsAvailabilityOfOpenactivitySection(testCaseName, browser);
    	
//*** Function for verifying status is Closed..
    	//BenefitClaimedPage_CV.verifyingStatusFieldInDecisionReasonSec(testCaseName, browser,"Status","Closed" /*rd.getCellData(DataTable, "Status_Label", TCID), rd.getCellData(DataTable, "Status_Closed", TCID)*/);

//*** Validating the task comments based on subject value..
    	BenefitClaimedPage_CV.verifyingColumnValuesOfActivityHistorySec(testCaseName, browser, "LTD Intake - Group Office:null (00EZ2431)", "Subject", "Task Comments", "This task is automatically closed since this Benef...", "Activity History", "Show");
    	
//*** Validating closed date..
    	BenefitClaimedPage_CV.verifyingClosedDateOFActivityHistorySection(testCaseName, browser, "Benefit Claimed Rolled Over to LTD (00EZ2431)", "Subject", "Closed", "Due Date");
 
//*** Validating the task comments based on subject value..
    	BenefitClaimedPage_CV.verifyingColumnValuesOfActivityHistorySec(testCaseName, browser, "Benefit Claimed Rolled Over to LTD (00EZ2431)", "Subject", "Task Comments", "Benefit Claimed Rolled Over to LTD by CVTest9 CV_M...", "Activity History", "Show");
   
 }
	
}
