package TestScripts;

import org.testng.annotations.Test;

import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.sic.base.DriverScript;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.GenericClass;
import PageObjects.HomePage_CV;
import PageObjects.LoginPage_CV;

public class TC010_IncompleteClaimReview extends DriverScript {
	public static String TCID="CV_002";
	public static String DataTable = "CV_REG";
	public static String testCaseName ="Incomplete Claim Review";
	public static String uri = "ws://localhost:5095";
	@Test
	 public static void tc010() throws Throwable
	{
	//LeanfT SDK configurations..
	     GenericClass.sdkConfig(uri);
	   //Loading MS access DB.
	 DBnBrowserloading(TCID,DataTable);	
	//Initializing browser with the active screen.
		browser = GenericClass.createActiveScreenBrowser();
 	
//Step-49
	//Clicking Edit button of BC claim detail Page..
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName,browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	//Confirm BC edit page navigation
	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(testCaseName,browser);
	//Update Decision Reason 
	BenefitClaimedPage_CV.updatingDecisionReasonFieldValues(testCaseName,browser, rd.getCellData(DataTable, "StatusForApproval_Incomplte", TCID), rd.getCellData(DataTable, "DecisionReason_Incomplete", TCID));
	
	//Change status reason drop down value.
	BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(testCaseName,browser, rd.getCellData(DataTable, "StatusReason_Label", TCID),  rd.getCellData(DataTable, "StatusReason_Incomplete", TCID));
	//Click button of BC edit page..
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(testCaseName,browser, rd.getCellData(DataTable, "Save_Button", TCID));
	//Confirm BC page navigation
	BenefitClaimedPage_CV.confirmingBenefitClaimedPageNavigation(testCaseName,browser);
	//Check field Value 
	BenefitClaimedPage_CV.checkingFieldValueInDecisionSec(testCaseName,browser, rd.getCellData(DataTable, "Status_Label", TCID), rd.getCellData(DataTable, "Status_IncompleteValue", TCID));
	//Verifying New tasks are Updated in Open Activity Section..
	BenefitClaimedPage_CV.validatingNewTaskDisplayedOpenActivitySec(testCaseName,browser,rd.getCellData(DataTable, "OpenActivity_IncompleteSubject", TCID) );
	//validating Due BusinessDays
	BenefitClaimedPage_CV.validatingDueBusinessDays1(testCaseName,browser, Integer.parseInt(rd.getCellData(DataTable, "OpenActivity_2BusinesDays", TCID)),
												"Anticipatory Benefit Claimed Review Completion (00EZ2432)"/*rd.getCellData(DataTable, "OpenActivity_IncompleteSubject", TCID)*/,
												rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_LastModifedHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_DueDateHeader", TCID));
	//Function for validating the AssignTo user name Open Activity section based on header name..
	BenefitClaimedPage_CV.verifyingColumnValueOFOpenActivitySec(testCaseName,browser, 
												rd.getCellData(DataTable, "OpenActivity_SubjectValue", TCID),
												rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_AssignUser", TCID));
//Step-50
	//Function for clicking Subject link in Open Activities section based on user inputs..
	BenefitClaimedPage_CV.clickingSubjectOfOpenActivitiesSec(testCaseName,browser,  rd.getCellData(DataTable, "OpenActivity_SubjectValue", TCID) );
	//Function for confirming Task page navigation..
	BenefitClaimedPage_CV.confirmingTaskPageNavigation(testCaseName,browser);
	
//Step-51
	//Function to click on Edit button of "Task Detail", Page based on the user inputs..
	BenefitClaimedPage_CV.clickButtonOfTaskDetailPage(testCaseName,browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	//Function for confirming Task Edit page navigation..
	BenefitClaimedPage_CV.confirmingTaskEditPageNavigation(testCaseName,browser);
//Step-52
	//Function for selecting status dropdown value based on user inputs..
	BenefitClaimedPage_CV.addingCommentsInTaskEditPage(testCaseName,browser, rd.getCellData(DataTable, "Comments_Label", TCID), rd.getCellData(DataTable, "Comments_Value_TaskPage", TCID));
	//Function to click on  Save button of "Task Edit", Page based on the user inputs..
	BenefitClaimedPage_CV.clickButtonOfTaskEditPage(testCaseName,browser, rd.getCellData(DataTable, "Save_Button", TCID));
	//Function for confirming Task page navigation..
	BenefitClaimedPage_CV.confirmingTaskPageNavigation(testCaseName,browser);
//Step-53
	//Function to click On link ofTask detail section based on label.
	BenefitClaimedPage_CV.clickLinkOfTaskDetailSection(testCaseName, browser, rd.getCellData(DataTable, "Related_To_label", TCID));
	//Confirm BC page navigation
	BenefitClaimedPage_CV.confirmingBenefitClaimedPageNavigation(testCaseName,browser);
	
//Step-54
	//Click button of BC detail page..
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName,browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	//Confirm BC edit page navigation
	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(testCaseName,browser);
	//Function to select date based on label and the date passed by user of information section.
	
	BenefitClaimedPage_CV.selectDateOfInformationSection(testCaseName, browser, rd.getCellData(DataTable, "LastWorkDate_Label", TCID),
																rd.getCellData(DataTable, "LastWorkDate_Future", TCID));
	//Change status reason drop down value.
	BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(testCaseName,browser,rd.getCellData(DataTable, "StatusReason_Label", TCID) , 
																		rd.getCellData(DataTable, "StatusReason_IntakeIncomp", TCID) );
	//Click button of BC edit page..
	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(testCaseName,browser, rd.getCellData(DataTable, "Save_Button", TCID));
	
	//Check status reason field Value 
	
	BenefitClaimedPage_CV.checkingFieldValueInDecisionSec(testCaseName,browser, rd.getCellData(DataTable, "StatusReason_Label", TCID), rd.getCellData(DataTable, "StatusReason_Anticipatary", TCID));
	
	//Verifying New tasks are Updated in Open Activity Section..
	BenefitClaimedPage_CV.validatingNewTaskDisplayedOpenActivitySec(testCaseName,browser,rd.getCellData(DataTable, "OpenActivity_AnticipatoryBenefit", TCID) );
	/*Validating due business days*/
	BenefitClaimedPage_CV.validatingDueBusinessDays(testCaseName, browser, Integer.parseInt(rd.getCellData(DataTable, "OpenActivity_5BusinesDays", TCID)),
												rd.getCellData(DataTable, "OpenActivity_AnticipatoryBenefit", TCID),
												rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_LastModifedHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_DueDateHeader", TCID));
	//Function for validating the AssignTo user name Open Activity section based on header name..
	BenefitClaimedPage_CV.verifyingColumnValueOFOpenActivitySec(testCaseName, browser, 
												rd.getCellData(DataTable, "OpenActivity_AnticipatoryBenefit", TCID),
												rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
												rd.getCellData(DataTable, "OpenActivity_AssignUser", TCID));
	
	//Function for validating to StatusForApproval field value as blank
	BenefitClaimedPage_CV.validatingFieldValueAsBlank(testCaseName,browser, rd.getCellData(DataTable, "StatusForApproval_Label", TCID));
	//Function for validating to DecisionReasion field value as blank
	BenefitClaimedPage_CV.validatingFieldValueAsBlank(testCaseName, browser, rd.getCellData(DataTable, "DecisionReasion_Label", TCID));
	//Function to validate Required check box status of Open activity table.('Not Checked/Checked' are parameters of requiredChkBoxStatus)
	BenefitClaimedPage_CV.validatingRequiredChkBoxOfOpenActivityTable(testCaseName, browser,
															rd.getCellData(DataTable, "OpenActivity_AnticipatoryBenefit", TCID),
															rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
															rd.getCellData(DataTable, "OpenActivity_Required", TCID),
															rd.getCellData(DataTable, "CheckBox_Status", TCID));
	//Function for Verifying Closed tasks are Upadated in Activity history Section..
	BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(testCaseName,browser, rd.getCellData(DataTable, "ActivityHistory_Incomplete", TCID));
	
	
	
	/*Capturing the screenTitle of Last page of TC and then saving it in appData.properties file*/
	  String screentitle=browser.getTitle();
	  GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	}
	}
