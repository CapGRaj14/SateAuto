package TestScripts;

import java.net.URI;

import org.testng.annotations.Test;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.sic.accelerators.ActionEngine_Dialog;
import com.sic.base.DriverScript;

import PageObjects.GenericClass;
import PageObjects.HomePage_CV;
import PageObjects.LoginPage_CV;
import PageObjects.ReassignmentPage_CV;
import PageObjects.UpDateUser_CV;

public class TC020_ReassignClaim_BulkReassign extends DriverScript {
	
	public static String TCID="CV_TC020";
	public static String DataTable = "CV_REG";
	public static String testCaseName ="ReassignClaim_BulkReassign";
	public static String uri ="ws://localhost:5095";
	
	@Test
	
    public static void tc020() throws Throwable
 {
		/*isTestCaseRunnable(TCID, DataTable);
		LoginPage_CV.loginToClaimVantage(testCaseName, browser, "test_cv_mgmt_lead_auto@standard.com.int", "Password!1");*/
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		config.setServerAddress(new URI( uri));
	    SDK.init(config);
	    
	 browser = GenericClass.createActiveScreenBrowser();
	 DBnBrowserloading(TCID, DataTable);
	 
//Step 113
	 
//*** Clicking Reassignment Tab..
	 HomePage_CV.clickingTabForNavigation(browser, rd.getCellData(DataTable, "Tab", TCID));

//*** Navigated to Benefit Claim Reassignment Screen..
	 GenericClass.navigationBasedOnH2HeaderText(browser, rd.getCellData(DataTable, "BCReassgnment_Header", TCID));
	 
//Step 114
	 
//*** Selected Benefit Claimed Status Dropdown field value as Approved..
	 ReassignmentPage_CV.selectingBenefitClaiedStatusValue(testCaseName, browser, rd.getCellData(DataTable, "BenefitClaimedStatus_Label", TCID),
			 																	rd.getCellData(DataTable, "BenefitClaimed_StatusValue", TCID));
 
//*** Clicking on Search button..
	 ReassignmentPage_CV.ClickOnButton(browser, rd.getCellData(DataTable, "Search_Button", TCID), 
			 									rd.getCellData(DataTable, "BCReassgnment_Header", TCID));
	 
//*****************************Expected results not included(Need clarification)**************************//*
	 
//Step 115
	 
//*** select at least two check boxes under search results screen..
	 ReassignmentPage_CV.selectingCheckBoxUnderSearchResultsPage(testCaseName, browser, rd.getCellData(DataTable, "CheckBox_Status", TCID));
	// ReassignmentPage_CV.selectingCheckBoxUnderSearchResultsPage(testCaseName, browser, rd.getCellData(DataTable, "CheckBox_Status", TCID));
 
//*** Clicking next button..
	 ReassignmentPage_CV.ClickOnButton(browser, rd.getCellData(DataTable, "Next_Button", TCID), 
												rd.getCellData(DataTable, "BCReassgnment_Header", TCID));

//*** Navigated to New Assigned User Selection screen..
	 GenericClass.navigationBasedOnH2HeaderText(browser, rd.getCellData(DataTable, "NewAssignedUser_Header", TCID));

//*** Validate Updated message..
	 ReassignmentPage_CV.verifyingUpdatedMessage(testCaseName, browser, rd.getCellData(DataTable, "AutoReassignmnet_Mesg", TCID));
	 
	 
//Step 116
	 
//*** Click on previous button..
	 ReassignmentPage_CV.ClickOnButton(browser, rd.getCellData(DataTable, "Previous_Button", TCID), 
												rd.getCellData(DataTable, "NewAssignedUser_Header", TCID));
	 
//*** Navigated to benefit claimed reassignment screen..
	 boolean fnStatus=isElementExist(browser, ReassignmentPage_CV.txtBCReassignmentHeader);
	 GenericClass.reportlogger(fnStatus, testCaseName, "User Navigated to Benefit Claimed Reassignment Screen");

//Step 117
	 
//*** Filling Search Criteria section fields..
	 
	 ReassignmentPage_CV.fillingSearchCriteriaSectionFields(testCaseName, browser, rd.getCellData(DataTable, "AssignedUser_Name", TCID),
			 																		rd.getCellData(DataTable, "BenefitClaimedStatus_Label", TCID),
			 																		rd.getCellData(DataTable, "BenefitClaimed_StatusValue", TCID),
			 																		rd.getCellData(DataTable, "PolicyNumber_Label", TCID));
//*** Clicking on Search button..
	 ReassignmentPage_CV.ClickOnButton(browser, rd.getCellData(DataTable, "Search_Button", TCID), 
				 									rd.getCellData(DataTable, "BCReassgnment_Header", TCID));
		
//*** Checking BenefitClaimed list..
	 ReassignmentPage_CV.checkingBenefitClaimedList(testCaseName, browser);

//Step 118
//*** Clicking on Next button..
		 ReassignmentPage_CV.ClickOnButton(browser, rd.getCellData(DataTable, "Next_Button", TCID), 
					 								rd.getCellData(DataTable, "BCReassgnment_Header", TCID));
//*** Navigated to assigned user screen..
		 GenericClass.navigationBasedOnH2HeaderText(browser, rd.getCellData(DataTable, "NewAssignedUser_Header", TCID));
		 
//Step 119

//*** Enter new assigned user name..
		 ReassignmentPage_CV.enteringNewAssignedUserName(testCaseName, browser, rd.getCellData(DataTable, "SearchCriteria_Name", TCID));

//*** Clicking on Search button..
		 ReassignmentPage_CV.ClickOnButton(browser, rd.getCellData(DataTable, "Search_Button", TCID), 
					 								rd.getCellData(DataTable, "NewAssignedUser_Header", TCID));
//*** Verifying CV Claim handler name..
		 ReassignmentPage_CV.verifyCVclaimHandlerUserName(testCaseName, browser, rd.getCellData(DataTable, "SearchCriteria_Name", TCID));

//Step 120
		
//*** Selecting Radio Button..
		 UpDateUser_CV.selectingRadioButtonOfSearchResultsSec(browser);
//*** Select reason value as Other..
		fnStatus=GenericClass.selectValueByVisibleTextBasedOnLabel(browser, rd.getCellData(DataTable, "Reason_Label", TCID), rd.getCellData(DataTable, "Reason_Value", TCID));

//*** Click Reassign Button..
		 ReassignmentPage_CV.ClickOnButton(browser, rd.getCellData(DataTable, "Reassign_Button", TCID), 
												rd.getCellData(DataTable, "NewAssignedUser_Header", TCID));
//*** Validate Popup message..
		UpDateUser_CV.popUpMessageValidation(testCaseName, browser, rd.getCellData(DataTable, "PopUpMesg_Title", TCID) ,rd.getCellData(DataTable, "Assigned_PopupMesg", TCID));

//Step 121 		
//*** Clicking ok button ***
		fnStatus=ActionEngine_Dialog.fnOKorCancelButtonInDialodBox(browser, rd.getCellData(DataTable, "PopUpMesg_Title", TCID),
																			rd.getCellData(DataTable, "Dialog_Button", TCID));
		GenericClass.reportlogger(fnStatus,testCaseName,"Clicked on " + rd.getCellData(DataTable, "Dialog_Button", TCID) + ", button");

//*** Navigated to Benefit Claim Reassignment Screen..
		 GenericClass.navigationBasedOnH2HeaderText(browser, rd.getCellData(DataTable, "BCReassgnment_Header", TCID));
//*** Validate Updated message..
		 ReassignmentPage_CV.verifyingUpdatedMessage(testCaseName, browser, rd.getCellData(DataTable, "BenefitClaimed_UpdatedMesg", TCID));
		 
//Step 122
		 
//*** Clicked Benefit Climed ID..
		 ReassignmentPage_CV.clickingBCLinkInSearchResultsSection(testCaseName, browser, rd.getCellData(DataTable, "BenefitClaimed_ID", TCID));
		 
//*** Navigated to benefit Climed id page..
		 GenericClass.navigationBasedOnH2HeaderText(browser, rd.getCellData(DataTable, "BenefitClaimed_ID", TCID));

//*** Verifying assigned user name..
		//td[text()='Custom Links']/../../../..//table
}

}
