package TestScripts;

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.Properties;

import org.testng.annotations.Test;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.GenericClass;
import PageObjects.LoginPage_CV;
import PageObjects.UpDateUser_CV;

public class TC013_ClaimDenied extends DriverScript{
	public static String TCID="CV_002";
	public static String DataTable = "CV_REG";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties"; 
	public static String testCaseName ="Claim Denied";
	public static String uri = "ws://localhost:5095";
	 @Test
	
	    public static void tc013() throws Throwable{
	    	
		//LeanfT SDK configurations..
		 GenericClass.sdkConfig(uri);
		//Loading MS access DB.
		 DBnBrowserloading(TCID,DataTable);	
		//Initializing browser with the active screen.
		 browser = GenericClass.createActiveScreenBrowser();
			
		
	ReportEvent.testStepReport("", "Info", testCaseName);
	
//Step-62
	
	//Click Edit button
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName, browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	//Confirm BC edit page navigation..
	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(testCaseName, browser);
	//Update Decision reason field value
	BenefitClaimedPage_CV.updatingDecisionReasonFieldValues(testCaseName, browser,"Denied","Incorrect Claim Setup"
												/*rd.getCellData(DataTable, "StatusApproval_ClaimDenied", TCID),
												rd.getCellData(DataTable, "DecisionReason_ClaimDenied", TCID)*/);
	
	//Click Save button..
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(testCaseName, browser, rd.getCellData(DataTable, "Save_Button", TCID));
	//Function for validating error message in Decision reason section based on label
	BenefitClaimedPage_CV.validatingDeniedErrorMessage(testCaseName, browser, "Error: Cannot set Status For Approval to Denied as All Required Tasks on the Benefit Claimed must be completed");
	
	
//Step-63
	
	//Click Cancel button..
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(testCaseName, browser,"Cancel"/* rd.getCellData(DataTable, "Cancel_Button", TCID)*/);
	
	// Loading the config.properties file..
	File f = new File(configFilepath);
	 FileReader fr = new FileReader(f);
	 Properties prop = new Properties();
	 prop.load(fr);
	 GenericClass.saveGeneratedDataInConfigFile(browser, "Benefit Claimed", "benefitID");
	 String bcID = prop.getProperty("benefitID");
	 
	//Navigation to BC ID page..
	GenericClass.navigationBasedOnH2HeaderText(browser, bcID);
	
	//Function for verifying the status for approval and Decision reason field values..
	BenefitClaimedPage_CV.validatingDecisionReasonSecFieldValues(testCaseName, browser, "Status for Approval","Decision Reason","Pending","Requesting Additional Employer Info");
																	  /*rd.getCellData(DataTable, "StatusApproval_DeniedLabel", TCID),
																		rd.getCellData(DataTable, "DecisionReason_DeniedLabel", TCID),
																		rd.getCellData(DataTable, "StatusApproval_PendingValue", TCID),
																		rd.getCellData(DataTable, "DecisionReason_AdditionalEmp", TCID));*/
	
//Step-64
	//Function for clicking CLS link in Open Activities section..
	BenefitClaimedPage_CV.clickingActionTypeOfOpenActivitiesSec(testCaseName,browser,"Pending Review Complete (00EZ2472)","Cls");/*
																		rd.getCellData(DataTable, "OpenActivities_SubjectValue", TCID),
																		rd.getCellData(DataTable, "OpenActivities_ActionType", TCID));*/
	//Confirm navigation to Task edit page..
	BenefitClaimedPage_CV.confirmingTaskEditPageNavigation(testCaseName,browser);
	//Function for verifying status dropdown value as Completed..
	BenefitClaimedPage_CV.selectingStatusDropdownfieldValue(testCaseName, browser, rd.getCellData(DataTable, "Status_Label", TCID),"Completed"
																		/*rd.getCellData(DataTable, "Status_Value", TCID)*/);
	
//Step-65
	//Click Save button..
	BenefitClaimedPage_CV.clickButtonOfTaskEditPage(testCaseName, browser, rd.getCellData(DataTable, "Save_Button", TCID));
	//Navigation to BC ID page..
	GenericClass.navigationBasedOnH2HeaderText(browser, bcID);
	//Confirm navigation to BC page..
	BenefitClaimedPage_CV.confirmingBenefitClaimedPageNavigation(testCaseName, browser);
	
	//BenefitClaimedPage_CV.clickingOKbuttonOfDialogBox(browser, rd.getCellData(DataTable, "Dialog_Button", TCID));
	
	//Clicking open activities action type..
	BenefitClaimedPage_CV.clickingActionTypeOfOpenActivitiesSec(testCaseName,browser,rd.getCellData(DataTable, "OpenActivities_SubjectValue", TCID),
																	rd.getCellData(DataTable, "OpenActivities_ActionType", TCID));
	//Verify Pending Review Complete task availability..
	BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(testCaseName,browser, "Pending Review Complete (00EZ2472)"/*rd.getCellData(DataTable, "ActivityHistory_Subject", TCID)*/);
	
//Step-66	
	//CLick Edit button
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName, browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	//Navigation to BC edit page..
	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(testCaseName, browser);
	//Update decision reason field..
	BenefitClaimedPage_CV.updatingDecisionReasonFieldValues(testCaseName, browser,"Denied","Incorrect Claim Setup"
										/*rd.getCellData(DataTable, "StatusApproval_ClaimDenied1", TCID),
										rd.getCellData(DataTable, "DecisionReason_ClaimDenied1", TCID)*/);
	//Click Save button
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(testCaseName, browser, rd.getCellData(DataTable, "Save_Button", TCID));
	//Click submit for approval button..
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName,browser,"Submit for Approval"/* rd.getCellData(DataTable, "Submit_Button", TCID)*/);
	//Function for Validating the Updated date values based on different timezones in Approval history section..
	BenefitClaimedPage_CV.verifyingDateColumnInModifiedDateApprovalHistorySec(testCaseName, browser,"Asia/Calcutta","US/Pacific");
	//Function for Selecting OK button of Dialog box..
	BenefitClaimedPage_CV.clickingOKbuttonOfDialogBox(testCaseName,browser,rd.getCellData(DataTable, "PopUpMesg_Title", TCID) , rd.getCellData(DataTable, "Dialog_Button", TCID));
	
	//Function for verifying the Status for approval value as Denied..
	BenefitClaimedPage_CV.verifyingStatusFieldInDecisionReasonSec(testCaseName, browser,rd.getCellData(DataTable, "Status_Label", TCID),"Denied"/*rd.getCellData(DataTable, "Status_DeniedValue", TCID)*/);
	
	//Validate task availability in open activities section..
	BenefitClaimedPage_CV.validatingNewTaskDisplayedOpenActivitySec(testCaseName, browser, "Communicate Denied Decision to Claimant (00EZ2472)"/*rd.getCellData(DataTable, "OpenActivity_DeniedTask", TCID)*/);
	//Function for validating the AssignTo user name Open Activity section based on header name..
	BenefitClaimedPage_CV.verifyingColumnValueOFOpenActivitySec(testCaseName, browser, "Communicate Denied Decision to Claimant (00EZ2472)","Subject","Assigned To","CVTest6 CV_ClaimsHandler_Auto");
	/*rd.getCellData(DataTable, "OpenActivity_DeniedTask", TCID),
	rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
	rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
	rd.getCellData(DataTable, "OpenActivity_PendingAssignUser", TCID));*/

	//Validate due business days..
	BenefitClaimedPage_CV.validatingDueBusinessDays(testCaseName, browser,5,"Communicate Denied Decision to Claimant (00EZ2472)","Subject","Last Modified Date","Due Date");/* Integer.parseInt(rd.getCellData(DataTable, "OpenActivity_5BusinessDays", TCID)*///),
	/*rd.getCellData(DataTable, "OpenActivity_DeniedTask", TCID),
	rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
	rd.getCellData(DataTable, "OpenActivity_LastModifedHeader", TCID),
	rd.getCellData(DataTable, "OpenActivity_DueDateHeader", TCID));*/


//Step-67

	//Function for clicking Cls link in Open Activities section..
	BenefitClaimedPage_CV.clickingActionTypeOfOpenActivitiesSec(testCaseName, browser,"Communicate Denied Decision to Claimant (00EZ2472)","Cls"/*rd.getCellData(DataTable, "OpenActivities_SubjectValue", TCID),rd.getCellData(DataTable, "OpenActivities_SubjectValue", TCID)*/);


//Navigation to Task edit page..
BenefitClaimedPage_CV.confirmingTaskEditPageNavigation(testCaseName, browser);
//Select status dropdown value as completed..
BenefitClaimedPage_CV.selectingStatusDropdownfieldValue(testCaseName, browser, rd.getCellData(DataTable, "Status_Label", TCID),"Completed"
			/*rd.getCellData(DataTable, "Status_Value", TCID)*/);

//Step-68	
	//Click Save button..
	BenefitClaimedPage_CV.clickButtonOfTaskEditPage(testCaseName,browser, rd.getCellData(DataTable, "Save_Button", TCID));
	//Navigate to BC ID page..
	GenericClass.navigationBasedOnH2HeaderText(browser, bcID);
	//Function for Verifying Closed tasks are Upadated in Activity history Section..
	BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(testCaseName, browser,"Communicate Denied Decision to Claimant (00EZ2472)" /*rd.getCellData(DataTable, "ActivityHistory_Subject", TCID)*/);



	
	 /*Capturing the screenTitle of Last page of TC and then saving it in appData.properties file*/
		String screentitle=browser.getTitle();
		GenericClass.setActiveScreenTitleInConfigFile(screentitle);

	
	 }
}
