package TestScripts;

import java.net.URI;

import org.testng.annotations.Test;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.Browser;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.AccountsPage_CV;
import PageObjects.BenefitClaimedPage_CV;
import PageObjects.ContactsPage_CV;
import PageObjects.GenericClass;
import PageObjects.HomePage_CV;
import PageObjects.TestCase_TestSteps;
import PageObjects.UpDateUser_CV;

public class TC003_AssignedAccountUsers extends DriverScript {
	
	public static String TCID="CV_001";
	public static String DataTable = "CV_REG";
	public static String testCaseName ="Assigned Account User";
	public static String uri ="ws://localhost:5095";
	
	 @Test
	
	    public static void mthd_AssignedAccountUsers() throws Throwable
	 {
		 GenericClass.sdkConfig(uri);
	     
		 browser = GenericClass.createActiveScreenBrowser();
		 DBnBrowserloading(TCID, DataTable);
	 
		 ReportEvent.testStepReport("", "Info", "Assigned Account Users");
	

//step 12,13 & 14
//*** Recursive deletion of records in Assigned Account user section..
	AccountsPage_CV.recursiveDeletionOfRecordsAssignedAccountSection(testCaseName, browser, rd.getCellData(DataTable, "Action_Value", TCID), 
																	rd.getCellData(DataTable, "PopUpMesg_Title", TCID), 
																	rd.getCellData(DataTable, "DeletePopUp_Mesg", TCID),
																	rd.getCellData(DataTable, "Dialog_Button", TCID));
	
//step 15

	AccountsPage_CV.clickingNewAssignedAccountUserButton(browser);
	
	AccountsPage_CV.confirmingNewAssignedAccountUserPageNavigation(browser);

//step 16	
	
	AccountsPage_CV.fillingAssignedAccountUserInfoFields(browser, rd.getCellData(DataTable, "ClaimComplexity_Available", TCID), rd.getCellData(DataTable, "ClaimComplexity_Available2", TCID), rd.getCellData(DataTable, "BenefitType_Available", TCID));
	
	UpDateUser_CV.selectingUserNameFromAssignedUserWindowFrame(browser, rd.getCellData(DataTable, "SearchCriteria_Name", TCID));
	
	AccountsPage_CV.verifyingChosenListBoxValuesInClaimComplexity(browser, rd.getCellData(DataTable, "ClaimComplexity_ListBoxValues", TCID));
	
	AccountsPage_CV.verifyingChosenValuesInBenefitType(browser, rd.getCellData(DataTable, "BenefitType_ListBoxValues", TCID));
	
	AccountsPage_CV.clickButtonOfAssignedAccountUserEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
	
	AccountsPage_CV.confirmingAssignedAccountUserPageNavigation(browser);
	
	AccountsPage_CV.checkingAssignedAccountUserDetailSecFields(browser, rd.getCellData(DataTable, "AssignedAccountDetail_Fields", TCID));
	
//step 17
	AccountsPage_CV.clickingAccountNameAssignedAccUserDetailPage(browser, rd.getCellData(DataTable, "AccountName_Label", TCID));
	
	GenericClass.navigationBasedOnH2HeaderText(browser, rd.getCellData(DataTable, "Account_Name", TCID));
	
	AccountsPage_CV.verifyingCVHndlrInAssignAccUserSec(testCaseName, browser, rd.getCellData(DataTable, "Section_Name", TCID), "", rd.getCellData(DataTable, "SearchCriteria_Name", TCID));

//*** Clicking New Assigned Account User Button..
	AccountsPage_CV.clickingNewAssignedAccountUserButton(browser);
	
//Navigated to new Assigned Account page..
	AccountsPage_CV.confirmingNewAssignedAccountUserPageNavigation(browser);

//step 16	
//*** Filling Assigned account User information section fields..
	AccountsPage_CV.fillingAssignedAccountUserInfoFields(browser, rd.getCellData(DataTable, "ClaimComplexity_Available", TCID),
																rd.getCellData(DataTable, "ClaimComplexity_Available2", TCID),
																rd.getCellData(DataTable, "BenefitType_Available", TCID));

//*** Selecting UserName..
	UpDateUser_CV.selectingUserNameFromAssignedUserWindowFrame(browser, rd.getCellData(DataTable, "SearchCriteria_Name", TCID));
	
//*** Verifying Chosen listbox values..	
	AccountsPage_CV.verifyingChosenListBoxValuesInClaimComplexity(browser, rd.getCellData(DataTable, "ClaimComplexity_ListBoxValues", TCID));
	
//*** Verifying BenefitType List box value..
	AccountsPage_CV.verifyingChosenValuesInBenefitType(browser, rd.getCellData(DataTable, "BenefitType_ListBoxValues", TCID));
	
//*** Click Save button..
	AccountsPage_CV.clickButtonOfAssignedAccountUserEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));

//*** Navigated to Assigned Account User page navigation..
	AccountsPage_CV.confirmingAssignedAccountUserPageNavigation(browser);
	
//*** Checking Assigned account user details section fields..	
	AccountsPage_CV.checkingAssignedAccountUserDetailSecFields(browser, rd.getCellData(DataTable, "AssignedAccountDetail_Fields", TCID));
	
//step 17
//*** Click Account name link..
	AccountsPage_CV.clickingAccountNameAssignedAccUserDetailPage(browser, rd.getCellData(DataTable, "AccountName_Label", TCID));
	
//*** Navigated to account name page..
	GenericClass.navigationBasedOnH2HeaderText(browser, rd.getCellData(DataTable, "Account_Name", TCID));
	
//*** Verifying CV Claimhandler name..
	AccountsPage_CV.verifyingCVHndlrInAssignAccUserSec(testCaseName, browser, rd.getCellData(DataTable, "Section_Name", TCID), "",
																				rd.getCellData(DataTable, "SearchCriteria_Name", TCID));

	
	String screentitle=browser.getTitle();
	GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	
	 }
}
