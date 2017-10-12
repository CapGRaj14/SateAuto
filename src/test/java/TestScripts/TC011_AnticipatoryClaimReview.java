package TestScripts;

import org.testng.annotations.Test;

import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.GenericClass;
import PageObjects.HomePage_CV;

public class TC011_AnticipatoryClaimReview extends DriverScript {
	public static String TCID="CV_002";
	public static String DataTable = "CV_REG";
	public static String uri = "ws://localhost:5095";
	public static String testCaseName ="Anticipatory Claim Review";
	
	
	 @Test
	
	    public static void tc011() throws Throwable
	 {
	//LeanfT SDK configurations..
	     GenericClass.sdkConfig(uri);
	//Loading MS access DB.
	 DBnBrowserloading(TCID,DataTable);	
	//Initializing browser with the active screen.
		browser = GenericClass.createActiveScreenBrowser();
		

	ReportEvent.testStepReport("", "Info", "Anticipatory Claim Review");

//Step-55
	//Clicking Edit button of BC claim detail Page..
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName, browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	//Confirm BC Edit page navigation
	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(testCaseName, browser);
	//Change status reason drop down value..
	BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(testCaseName, browser,rd.getCellData(DataTable, "StatusReason_Label", TCID) , rd.getCellData(DataTable, "StatusReason_Value", TCID) );
	
	//Click Save button
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(testCaseName, browser, rd.getCellData(DataTable, "Save_Button", TCID));
	//Function for verifying the Decision reason section field values..
	BenefitClaimedPage_CV.verifyingDecisionReasonSecFieldValues(testCaseName,browser, rd.getCellData(DataTable, "Status_Label", TCID), rd.getCellData(DataTable, "StatusReason_Label", TCID),rd.getCellData(DataTable, "Status_Pending", TCID),
			rd.getCellData(DataTable, "StatusReason_Anticipatory", TCID));

//Step-56	
	//Clicking on Name related link of Open activity action types..
	BenefitClaimedPage_CV.clickingLinkOfOpenActivitySecActionType(testCaseName, browser,  rd.getCellData(DataTable, "OpenActivity_Subject", TCID),
																			rd.getCellData(DataTable, "OpenActAction_Type", TCID));
	//Confirm Task edit page navigation
	BenefitClaimedPage_CV.confirmingTaskEditPageNavigation(testCaseName, browser);
	//Select status dropdown value..
	BenefitClaimedPage_CV.selectingStatusDropdownfieldValue(testCaseName, browser, rd.getCellData(DataTable, "Status_Label", TCID),rd.getCellData(DataTable, "Status_Value", TCID));
//Step-57
	//Click Save button
	BenefitClaimedPage_CV.clickButtonOfTaskEditPage(testCaseName,browser, rd.getCellData(DataTable, "Save_Button", TCID));
	//Confirm BC page navigation..
	BenefitClaimedPage_CV.confirmingBenefitClaimedPageNavigation(testCaseName, browser);
	//Verifying task in activity history..
	BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(testCaseName,browser, rd.getCellData(DataTable, "ActivityHistory_Subject", TCID));
//Step-58
	//Click Edit button of BC detail page.
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName, browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	//Confirm BC edit page navigation..
	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(testCaseName, browser);
	//Function for selecting last date of working in benefit claimed section..
	BenefitClaimedPage_CV.selectingLastWorkDate(testCaseName,browser, rd.getCellData(DataTable, "LostWork_DatePast", TCID));
	//Change status reason value
	BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(testCaseName,browser,rd.getCellData(DataTable, "StatusReason_Label", TCID) , rd.getCellData(DataTable, "StatusReason_Value", TCID) );
	//Click save button
	BenefitClaimedPage_CV.clickButtonOfTaskEditPage(testCaseName, browser, rd.getCellData(DataTable, "Save_Button", TCID));
	
	/*Capturing the screenTitle of Last page of TC and then saving it in appData.properties file*/
	String screentitle=browser.getTitle();
	GenericClass.setActiveScreenTitleInConfigFile(screentitle); 
	 }
}
