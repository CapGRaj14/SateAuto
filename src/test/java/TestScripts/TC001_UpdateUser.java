package TestScripts;

import java.net.URI;

import org.testng.annotations.Test;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.accelerators.ActionEngine_Dialog;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.GenericClass;
import PageObjects.HomePage_CV;
import PageObjects.LoginPage_CV;
import PageObjects.TestCase_TestSteps;
import PageObjects.UpDateUser_CV;

public class TC001_UpdateUser extends DriverScript{
	
	public static String TCID="CV_001";
	public static String DataTable = "CV_REG";
	public static String testCaseName ="TC001_UPDate User";
	
	@Test
    
public static void tc01() throws Throwable{
    
		isTestCaseRunnable(TCID, DataTable);
		
		boolean fnStatus=false;
		ReportEvent.testStepReport(testCaseName, "Info", "Update User Login");
		
		
//*** Enter Username , Password and click Login button		
		LoginPage_CV.loginToClaimVantage(testCaseName, browser, rd.getCellData(DataTable, "tUserName", TCID), 
				  												rd.getCellData(DataTable, "tPassword", TCID));
	
//Step 1
// *** Home Page validation ***
		HomePage_CV.confirmingHomePageNavigation(testCaseName,browser, rd.getCellData(DataTable, "HomePage_CurrentStatus", TCID));
	
//Step 2
// *** Navigation to the button ***
    	fnStatus=HomePage_CV.clickingTabForNavigation(browser, rd.getCellData(DataTable, "Tab", TCID));
		
//*** Confirming Edit user Screen ***
		UpDateUser_CV.confirmingEditUserPage(testCaseName,browser);
		
 //Step 3
//*** Selecting Name from Search creteria Section ***
    	UpDateUser_CV.selectingNameFromSearchCreteriaWindowFrame(testCaseName,browser, rd.getCellData(DataTable, "SearchCriteria_Name", TCID));
		    
//*** Clicked Search button ***
    	UpDateUser_CV.clickButtonOfSearchResultsPage(testCaseName,browser,rd.getCellData(DataTable, "Search_Button", TCID));
    	    				
//*** Checking Search Results Column fields ***
    	UpDateUser_CV.checkingSearchResultsColumnFields(testCaseName,browser, rd.getCellData(DataTable, "SearchCriteria_SecFields", TCID));
     
//Step 4
//*** Selection of Radio button ***  	
    	fnStatus=UpDateUser_CV.selectingRadioButtonOfSearchResultsSec(browser);
				
//*** Clicked Next Button ***
		UpDateUser_CV.clickButtonOfSearchResultsPage(testCaseName,browser,rd.getCellData(DataTable, "Next_Button", TCID));
				
//*** Confirming Update user Screen ***
		fnStatus = isElementExist(browser, UpDateUser_CV.txtUpdateUserHeader);
		GenericClass.reportlogger(fnStatus,testCaseName,"System should be Displayed Upadte User page");
		
//Step 5
//*** Selection approver name ***
    	UpDateUser_CV.selectingApproverForApprovalsFromSearchCreteriaWindowFrame(testCaseName,browser,rd.getCellData(DataTable, "SearchCriteria_ApprovalName", TCID));
    	
//*** Click Update Button ***
    	UpDateUser_CV.clickButtonOfSearchResultsPage(testCaseName,browser,rd.getCellData(DataTable, "Update_Button", TCID));
			
//*** Validate Popup message ***
		UpDateUser_CV.popUpMessageValidation(testCaseName, browser, rd.getCellData(DataTable, "PopUpMesg_Title", TCID) ,rd.getCellData(DataTable, "PopUp_Message", TCID));
//Step 6
//*** Clicking ok button ***
		//BenefitClaimedPage_CV.clickingOKbuttonOfDialogBox(testCaseName,browser, rd.getCellData(DataTable, "PopUpMesg_Title", TCID), rd.getCellData(DataTable, "Dialog_Button", TCID));
		fnStatus=ActionEngine_Dialog.fnOKorCancelButtonInDialodBox(browser, rd.getCellData(DataTable, "PopUpMesg_Title", TCID),
																			rd.getCellData(DataTable, "Dialog_Button", TCID));
		GenericClass.reportlogger(fnStatus,testCaseName,"Clicked on " + rd.getCellData(DataTable, "Dialog_Button", TCID) + ", button");
		
//*** Validate Updated Message ***
		UpDateUser_CV.verifyingUpdatedMessage(testCaseName,browser, rd.getCellData(DataTable, "SearchCriteria_Name", TCID));
		
    	String screentitle=browser.getTitle();
    	GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	
	}
}
