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

public class TC012_ClaimPending extends DriverScript{
	public static String TCID="CV_002";
	public static String DataTable = "CV_REG";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties"; 
	public static String uri = "ws://localhost:5095";
	public static String testCaseName ="Claim Pending";
	 @Test
	
	    public static void tc012() throws Throwable
	 {
		 
	//LeanfT SDK configurations..
	 GenericClass.sdkConfig(uri);
	//Loading MS access DB.
	 DBnBrowserloading(TCID,DataTable);	
	//Initializing browser with the active screen.
	 browser = GenericClass.createActiveScreenBrowser();
		
	ReportEvent.testStepReport("", "Info", testCaseName);
	// Loading the config.properties file..
	File f = new File(configFilepath);
	 FileReader fr = new FileReader(f);
	 Properties prop = new Properties();
	 prop.load(fr);
	 GenericClass.saveGeneratedDataInConfigFile(browser, "Benefit Claimed", "benefitID");
	 String bcID = prop.getProperty("benefitID");
	 
	 //Navigation to BC Id page..
	 GenericClass.navigationBasedOnH2HeaderText(browser, bcID);
	
//Step-59
	 //Clicking 'ALL' Check boxes in Open Activity Section
	BenefitClaimedPage_CV.clickingAllCheckboxOpenActivitySec(testCaseName,browser, rd.getCellData(DataTable, "CheckBox_Status", TCID));
	//Function to click on  CloseTask button of "OpenActivity Section" 
	BenefitClaimedPage_CV.clickButtonOfOpenActivitySection(testCaseName, browser,"Close Tasks"/* rd.getCellData(DataTable, "CloseTask_Button", TCID)*/);
	//Navigation to BC Id page..
	GenericClass.navigationBasedOnH2HeaderText(browser, bcID);
	//Refresh BC page.
	BenefitClaimedPage_CV.refreshingBenefitClaimedPage(testCaseName,browser);
	//Function for Verifying Closed tasks are Upadated in Activity history Section..
	BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(testCaseName, browser, "subjectValue");
	
//Step-60	
	//Click edit button of BC detail page..
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName,browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	//Navigation to BC Id page..
	GenericClass.navigationBasedOnH2HeaderText(browser, bcID);
	//confirm BC edit page navigation
	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(testCaseName,browser);
	//Function for Updating Decision Reason Field values based on user inputs..
	BenefitClaimedPage_CV.updatingDecisionReasonFieldValues(testCaseName, browser, "Pending","Requesting Additional Employer Info"/*rd.getCellData(DataTable, "StatusForApproval_ClaimPending", TCID) , rd.getCellData(DataTable, "DecisionReason_ClaimPending", TCID)*/ );
	//Function for Changing the status Reason to Reopen..
	BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(testCaseName,browser,rd.getCellData(DataTable, "StatusReason_Label", TCID) ,"Pending" /*rd.getCellData(DataTable, "StatusReason_ClaimPending", TCID)*/ );
	//Click Save button.
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(testCaseName,browser, rd.getCellData(DataTable, "Save_Button", TCID));
	//Function for Verifying Pending Decision Made tasks are Updated in Activity history Section..
	BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(testCaseName,browser,"Pending Decision Made: Requesting Additional Employer Info (00EZ2472)" /*rd.getCellData(DataTable, "Acivity_PendingTask", TCID)*/);
	
	//Function for validating the AssignTo user name Open Activity section based on header name..
	BenefitClaimedPage_CV.verifyingColumnValueOFActivityHistorySec(testCaseName,browser, "Pending Decision Made: Requesting Additional Employer Info (00EZ2472)",
												"Subject","Closed By","CVTest6 CV_ClaimsHandler_Auto"
												/*rd.getCellData(DataTable, "ActivityHistory_SubjectValue", TCID),
												rd.getCellData(DataTable, "ActivityHistory_SubjectHeader", TCID),
												rd.getCellData(DataTable, "ActivityHistory_ClosedByHeader", TCID),
												rd.getCellData(DataTable, "ActivityHistory_ClosedByValue", TCID)*/);
	//Function for validating the Closed by Date in Activity History section based on header name..
	BenefitClaimedPage_CV.verifyingClosedDateOFActivityHistorySec(testCaseName,browser, "Pending Decision Made: Requesting Additional Employer Info (00EZ2472)",
			"Subject","Closed","9/28/2017 4:51 AM"
			/*
												rd.getCellData(DataTable, "ActivityHistory_SubjectValue", TCID),
												rd.getCellData(DataTable, "ActivityHistory_SubjectHeader", TCID),
												rd.getCellData(DataTable, "ActivityHistory_ClosedHeader", TCID),
												rd.getCellData(DataTable, "ActivityHistory_ClosedDate", TCID)*/);

//Step-61
	//Click Edit button of BC page
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName, browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	//Confirm BC edit page navigation..
	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(testCaseName, browser);
	//Function for Changing the status Reason to Pending Review Complete..
	BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(testCaseName,browser,rd.getCellData(DataTable, "StatusReason_Label", TCID) ,"Pending Review Complete" /*rd.getCellData(DataTable, "StatusReason_PendingReview", TCID)*/ );
	//Click Save button of BE edit page..
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(testCaseName,browser, rd.getCellData(DataTable, "Save_Button", TCID));
	
	//Validate "Pending Review Complete" task in open activities section..
	BenefitClaimedPage_CV.validatingNewTaskDisplayedOpenActivitySec(testCaseName,browser,"Pending Review Complete (00EZ2472)" /*rd.getCellData(DataTable, "OpenActivity_PendingReview", TCID) */);
	//verifying column values of Open activities section..
	BenefitClaimedPage_CV.verifyingColumnValueOFOpenActivitySec(testCaseName,browser, "Pending Review Complete (00EZ2472)","Subject","Assigned To","CVTest6 CV_ClaimsHandler_Auto"
												/*rd.getCellData(DataTable, "OpenActivity_PendingValue", TCID),
												rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_PendingAssignUser", TCID)*/);
	//Validate due business days..
	BenefitClaimedPage_CV.validatingDueBusinessDays(testCaseName, browser,0,"Pending Review Complete (00EZ2472)","Subject","Last Modified Date","Due Date" 
												/*Integer.parseInt(rd.getCellData(DataTable, "OpenActivity_SameDay", TCID)),
												rd.getCellData(DataTable, "OpenActivity_PendingValue", TCID),
												rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_LastModifedHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_DueDateHeader", TCID)*/);
	//Function to validate Required check box status of Open activity table.('Not Checked/Checked' are parameters of requiredChkBoxStatus)
	BenefitClaimedPage_CV.validatingRequiredChkBoxOfOpenActivityTable(testCaseName, browser, "Pending Review Complete (00EZ2472)","Subject","Required","Checked"
												/*rd.getCellData(DataTable, "OpenActivity_PendingValue", TCID),
												rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_RequiredHeader", TCID),
												rd.getCellData(DataTable, "CheckBox_Status", TCID)*/);

	
	 BenefitClaimedPage_CV.storingAllSubjectText(browser);
	
	///have to include expected results/////////////////////////////

	 /*Capturing the screenTitle of Last page of TC and then saving it in appData.properties file*/
	String screentitle=browser.getTitle();
	GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	 }
}
